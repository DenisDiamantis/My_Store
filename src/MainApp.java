
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class MainApp {
	
	//Initializations
	private JFrame frmStoreApp;
	private static Product product;
	private static ArrayList<Product> devices;
	private static JList sortedList;
	private static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private static JButton btnOrder = new JButton("Order");
	private static JButton btnSale = new JButton("Sale");
	private static JButton btnCheckout = new JButton("Checkout");
	private static JButton btnSearch = new JButton("Search");
	private static JButton btnBack = new JButton("Back");
	private static JButton btnExit = new JButton("Exit");
	private static int tabIndex;
	private static int clickIndex;
	private static int category;
	private static int subCategory;
	private static int clickCounter;

	
	//Launch the application.
	public static void main(String[] args) {
		MainApp window = new MainApp();
		window.frmStoreApp.setVisible(true);
	}
	
	//Create Application
	public MainApp() {
		initialize();
	}
	
	//Initialize frame, contents of the frame and other functions
	private void initialize() {
		frmStoreApp = new JFrame();
		frmStoreApp.setTitle("Store App");
		frmStoreApp.setResizable(false);
		frmStoreApp.setBounds(650, 250, 636, 496);
		frmStoreApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStoreApp.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//Create and Add Tool Bar and Buttons on it
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frmStoreApp.getContentPane().add(toolBar, BorderLayout.NORTH);
		setupBackButton(btnBack);
		toolBar.add(btnBack);
		setupOrderButton(btnOrder);
		toolBar.add(btnOrder);
		setupSaleButton(btnSale);
		toolBar.add(btnSale);		
		setupCheckoutButton(btnCheckout);
		toolBar.add(btnCheckout);
		setupSearchButton(btnSearch);
		toolBar.add(btnSearch);
		setupExitButton(btnExit);
		toolBar.add(btnExit);
		
		//Add Tabbed Pane to Frame
		frmStoreApp.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		//Add actions to TabbedPane
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	        	tabIndex = tabbedPane.getSelectedIndex();
	        	switch(tabIndex){
	        	case 0:
	        		btnSearch.setEnabled(false);
	        		btnCheckout.setEnabled(false);
	        		tabbedPane.setComponentAt(0, showCategories());
	        		break;
	        	case 1:
	        		btnSearch.setEnabled(true);
	        		btnBack.setEnabled(false);
	        		btnOrder.setEnabled(false);
	        		btnSale.setEnabled(false);
	        		break;
	        	case 2:
	        		btnSearch.setEnabled(true);
	        		btnBack.setEnabled(false);
	        		btnOrder.setEnabled(false);
	        		btnSale.setEnabled(false);
	        		btnCheckout.setEnabled(false);
	        		break;
	        	}
	        }
	    });
		
		//Add Tabs to TabbedPane
		tabbedPane.addTab("Products", null, showCategories(), null);
		tabbedPane.addTab("Orders", null, new JScrollPane(makeOrderList()), null);
		tabbedPane.addTab("Sales", null,new JScrollPane(makeSaleList()), null);

		//Initialize Menu Bar
		JMenuBar menuBar = new JMenuBar();
		frmStoreApp.setJMenuBar(menuBar);
		
		//Add Menus and Menu Items in Menu Bar
		JMenu mnStoreApp = new JMenu("Load");
		menuBar.add(mnStoreApp);
		
		JMenuItem mntmLoadProducts = new JMenuItem("Products...");
		mntmLoadProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				fileChooser.setFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						return "Products File";
					}
					
					@Override
					public boolean accept(File f) {
						boolean isProductsFile = false;
						if(f.isDirectory() || f.getName().equals("Products.txt")) {
							isProductsFile = true;
						}
						return isProductsFile;
					}
				});
				int choice = fileChooser.showOpenDialog(frmStoreApp);
				if (choice == JFileChooser.APPROVE_OPTION) {
					   String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					   CatalogLoader.loadProductsCatalog(filePath);
					   }
				}
			}
		);
		
		mnStoreApp.add(mntmLoadProducts);
		
		JMenuItem mntmLoadOrders = new JMenuItem("Orders...");
		mntmLoadOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				fileChooser.setFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						return "Orders File";
					}
					
					@Override
					public boolean accept(File f) {
						boolean isOrdersFile = false;
						if(f.isDirectory() || f.getName().equals("Orders.txt")) {
							isOrdersFile = true;
						}
						return isOrdersFile;
					}
				});
				int choice = fileChooser.showOpenDialog(frmStoreApp);
				if (choice == JFileChooser.APPROVE_OPTION) {
					   String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					   CatalogLoader.loadOrdersCatalog(filePath);
					   tabbedPane.setComponentAt(1, makeOrderList());
					   }
				}
			}
		);
		mnStoreApp.add(mntmLoadOrders);
		
		JMenuItem mntmLoadSales = new JMenuItem("Sales...");
		mntmLoadSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				fileChooser.setFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						return "Sales File";
					}
					
					@Override
					public boolean accept(File f) {
						boolean isSalesFile = false;
						if(f.isDirectory() || f.getName().equals("Sales.txt")) {
							isSalesFile = true;
						}
						return isSalesFile;
					}
				});
				int choice = fileChooser.showOpenDialog(frmStoreApp);
				if (choice == JFileChooser.APPROVE_OPTION) {
					   String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					   CatalogLoader.loadSalesCatalog(filePath);
					   tabbedPane.setComponentAt(2, makeSaleList());
					   }
				}
			}
		);
		mnStoreApp.add(mntmLoadSales);
		
		JMenu mnSave = new JMenu("Save");
		menuBar.add(mnSave);
		
		JMenuItem saveProducts = new JMenuItem("Products...");
		saveProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
				fileChooser.setFileFilter(filter);
				int choice = fileChooser.showSaveDialog(frmStoreApp);
				if (choice == JFileChooser.APPROVE_OPTION){
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					CatalogWriter.writeProductsCatalog(CatalogLoader.productsCatalog, filePath);
				}
			}
		});
		mnSave.add(saveProducts);
		
		JMenuItem saveOrders = new JMenuItem("Orders...");
		saveOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
				fileChooser.setFileFilter(filter);
				int choice = fileChooser.showSaveDialog(frmStoreApp);
				if (choice == JFileChooser.APPROVE_OPTION){
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					CatalogWriter.writeOrdersCatalog(CatalogLoader.ordersCatalog, filePath);
				}
			}
		});
		mnSave.add(saveOrders);
		
		JMenuItem saveSales = new JMenuItem("Sales...");
		saveSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
				fileChooser.setFileFilter(filter);
				int choice = fileChooser.showSaveDialog(frmStoreApp);
				if (choice == JFileChooser.APPROVE_OPTION){
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					CatalogWriter.writeSalesCatalog(CatalogLoader.salesCatalog, filePath);
				}
			}
		});
		mnSave.add(saveSales);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutStoreApp = new JMenuItem("About Store App");
		mntmAboutStoreApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				JOptionPane.showMessageDialog(
						null,
                        "Store App\nVersion 3.0\nProject Created For Athens University Of Economics And Business",
                        "About Store App",
                        JOptionPane.INFORMATION_MESSAGE,
                        createImageIcon("images/about.png")
                );
			}
		});
		mnHelp.add(mntmAboutStoreApp);
	}
	
	//Method that finds image and returns it
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MainApp.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	//Method that creates the Product JList
	protected static JList makeProductList(){
		JList list = new JList();
		devices = filterDevices(category,subCategory);
		list.setListData(devices.toArray());
		list.setCellRenderer(new ProductRenderer());
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	JList thisList = (JList)e.getSource();
		    	int clickIndex = thisList.locationToIndex(e.getPoint());
		    	if(clickIndex != -1) { //clickIndex is -1 if the JList's model is empty
		    		product = devices.get(clickIndex);
		    		if (e.getClickCount() == 2) {
		    			JOptionPane.showMessageDialog(null, product.toString(), "Product Info", JOptionPane.INFORMATION_MESSAGE, createImageIcon("images/"+product.getIconName()));
		    		} else if (e.getClickCount() == 1) {
				        if(CatalogLoader.productsCatalog.get(product) == 0){
				        		btnOrder.setEnabled(true);
				        		btnSale.setEnabled(false);
				        } else if(CatalogLoader.productsCatalog.get(product) > 0) {
				        		btnSale.setEnabled(true);
				        		btnOrder.setEnabled(false);
				        }
		    		}
		    	}
		    }
		});
		return list;
	}
	
	//Mehtod that creates the Order JList
	protected static JList makeOrderList(){
		DefaultListModel modelOrder = new DefaultListModel();
		for(int i=0;i<CatalogLoader.ordersCatalog.size();i++){
		modelOrder.addElement(CatalogLoader.ordersCatalog.get(i));}
		JList list = new JList(modelOrder);
		list.setCellRenderer(new OrderRenderer());
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        JList thisList = (JList)e.getSource();
		        int clickIndex = thisList.locationToIndex(e.getPoint());
		    	if(clickIndex != -1) { //clickIndex is -1 if the JList's model is empty
		    		if(e.getClickCount() == 1) {
			        	if(CatalogLoader.ordersCatalog.get(clickIndex).getOrderStatus().equals("IN PROGRESS")){
				        	btnCheckout.setEnabled(true);
			        	} else {
			        		btnCheckout.setEnabled(false);
			        	}
			        } else if (e.getClickCount() == 2) {
			            JOptionPane.showMessageDialog(null,CatalogLoader.ordersCatalog.get(clickIndex).toString());
			        }
		    	}
		    }
		});
		return list;
	}
	
	//Method that creates the Sale JList
	protected static JList makeSaleList(){
		DefaultListModel modelSale = new DefaultListModel();
		for(int i=0;i<CatalogLoader.salesCatalog.size();i++){
		modelSale.addElement(CatalogLoader.salesCatalog.get(i));}
		JList list = new JList(modelSale);
		list.setCellRenderer(new SaleRenderer());
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	JList thisList = (JList)e.getSource();
		        int clickIndex = thisList.locationToIndex(e.getPoint());
		    	if(clickIndex != -1) { //clickIndex is -1 if the JList's model is empty
		    		if (e.getClickCount() == 2) {
			            JOptionPane.showMessageDialog(null,CatalogLoader.salesCatalog.get(clickIndex).toString());
			        }
		    	}
		    }
		});
		return list;
	}
	
	//Method that shows category menu
	protected static JList showCategories(){
		btnBack.setEnabled(false);
		btnOrder.setEnabled(false);
		btnSale.setEnabled(false);
		clickCounter = 0;
		DefaultListModel model = new DefaultListModel();
		model.addElement("Visual & Sound");
		model.addElement("Gaming");
		model.addElement("Home Appliances");
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        JList list = (JList)e.getSource();
		        if (e.getClickCount() == 2) {
		        	int index = list.locationToIndex(e.getPoint());
		            switch(index){
		            case 0:
		            	tabbedPane.setComponentAt(0, visualAndSoundSubCats());
		            	category = 1;
		            	btnBack.setEnabled(true);
		            	break;
		            case 1:
		            	tabbedPane.setComponentAt(0, gamingSubCats());
		            	category = 2;
		            	btnBack.setEnabled(true);
		            	break;
		            case 2:
		            	tabbedPane.setComponentAt(0, homeAppliancesSubCats());
		            	category = 3;
		            	btnBack.setEnabled(true);
		            	break;
		            }
		        }
		    }
		});
		return list;
	}
	
	//Method that shows visual & sound sub category
	protected static JList visualAndSoundSubCats(){
		btnOrder.setEnabled(false);
		btnSale.setEnabled(false);
		clickCounter = 2;
		DefaultListModel model = new DefaultListModel();
		model.addElement("TV");
		model.addElement("Player");
		model.addElement("Camera");
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				JList list = (JList)e.getSource();
				if (e.getClickCount() == 2){
					clickCounter+=2;
					int index = list.locationToIndex(e.getPoint());
					switch(index){
					case 0:
						subCategory = 1;
						tabbedPane.setComponentAt(0,makeProductList());
						break;
					case 1:
						subCategory = 2;
						tabbedPane.setComponentAt(0,makeProductList());
						break;
					case 2:
						subCategory = 3;
						tabbedPane.setComponentAt(0,makeProductList());
						break;
					}
				}
			}
		});
		return list;
	}
	
	//Method that shows gaming sub category
	protected static JList gamingSubCats(){
		btnOrder.setEnabled(false);
		btnSale.setEnabled(false);
		clickCounter = 2;
		DefaultListModel model = new DefaultListModel();
		model.addElement("Console");
		model.addElement("Portable Console");
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				JList list = (JList)e.getSource();
				if (e.getClickCount() == 2){
					clickCounter+=2;
					int index = list.locationToIndex(e.getPoint());
					switch(index){
					case 0:
						subCategory = 1;
						tabbedPane.setComponentAt(0,makeProductList());
						break;
					case 1:
						subCategory = 2;
						tabbedPane.setComponentAt(0,makeProductList());
						break;
					}
				}
			}
		});
		return list;
	}
	
	//Method that shows home appliances sub category
	protected static JList homeAppliancesSubCats(){
		btnOrder.setEnabled(false);
		btnSale.setEnabled(false);
		clickCounter = 2;
		DefaultListModel model = new DefaultListModel();
		model.addElement("Fridge");
		model.addElement("Washing Machine");
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				JList list = (JList)e.getSource();
				if (e.getClickCount() == 2){
					clickCounter+=2;
					int index = list.locationToIndex(e.getPoint());
					switch(index){
					case 0:
						subCategory = 1;
						tabbedPane.setComponentAt(0,makeProductList());
						break;
					case 1:
						subCategory = 2;
						tabbedPane.setComponentAt(0,makeProductList());
						break;
					}
				}
			}
		});
		return list;
	}
	
	//Method that sets BackButton's properties
	protected static void setupBackButton(JButton btnBack){
		btnBack.setToolTipText("Click to return to the previous list");
		btnBack.setIcon(createImageIcon("images/back.png"));
		btnBack.setEnabled(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clickCounter == 2){
					tabbedPane.setComponentAt(0, showCategories());
				}else if(clickCounter == 4){
					if(category == 1 && subCategory == 1||category == 1 && subCategory == 2||category == 1 && subCategory == 3){
						tabbedPane.setComponentAt(0, visualAndSoundSubCats());
					}else if(category == 2 && subCategory == 1||category == 2 && subCategory == 2){
						tabbedPane.setComponentAt(0, gamingSubCats());
					}else if(category == 3 && subCategory == 1||category == 3 && subCategory == 2){
						tabbedPane.setComponentAt(0, homeAppliancesSubCats());
					}
				}
			}
		});
	}
	
	//Method that sets OrderButton's properties and updates order list tab
	protected static void setupOrderButton(JButton btnOrder){
		btnOrder.setToolTipText("Click to make a new order.");
		btnOrder.setIcon(createImageIcon("images/order.png"));
		btnOrder.setEnabled(false);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField field1 = new JTextField();
				JTextField field2 = new JTextField();
				JTextField field3 = new JTextField();
				JTextField field4 = new JTextField();
				JTextField field5 = new JTextField();
				Object[] message = {
				    "Enter customer name:", field1,
				    "Enter customer surname:", field2,
				    "Enter customer phone:", field3,
				    "Enter order date (dd.MM.YYYY):", field4,
				    "Enter estimated date of arrival (dd.MM.YYYY):", field5};
				int option = JOptionPane.showConfirmDialog(null, message, "Complete new Order's Information", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION)
				{
					//Save inputs into variables
					String customerName = field1.getText();
					String customerSurname = field2.getText();
					String customerPhone = field3.getText();
					String orderDateString = field4.getText();
					String orderETAString = field5.getText();
					while(!validateDateInput(orderDateString)) {
						orderDateString = JOptionPane.showInputDialog("Insert Valid Order Date (dd.MM.YYYY):",null);
						if(orderDateString == null) { orderDateString = ""; }
					}
					while(!validateDateInput(orderETAString)) {
						orderETAString = JOptionPane.showInputDialog("Insert Valid Order ETA Date (dd.MM.YYYY):",null);
						if(orderETAString == null) { orderETAString = ""; }
					}
					Date orderDate = stringToDate(orderDateString);
					Date orderETA = stringToDate(orderETAString);
					Double orderCost = product.getPrice() - (product.getPrice()*product.getDiscount());
					
					//Add Sale to Orders' Catalog
					CatalogLoader.ordersCatalog.add(new Order(CatalogLoader.orderCode,product,customerName,customerSurname,customerPhone,orderDate,orderETA,
							orderCost,Constants.ORDER_STATUS_IN_PROGRESS));
					tabbedPane.setComponentAt(1, makeOrderList());
					
					//Increment of the order code
					CatalogLoader.orderCode++;
					
					JOptionPane.showMessageDialog(null, "The final cost is: " + orderCost, "Order Complete",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	//Method that sets SaleButton's properties and updates the sale list tab
	protected static void setupSaleButton(JButton btnSale){
		btnSale.setToolTipText("Click to make a sale.");
		btnSale.setIcon(createImageIcon("images/sale.png"));
		btnSale.setEnabled(false);
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField field1 = new JTextField();
				JTextField field2 = new JTextField();
				JTextField field3 = new JTextField();
				JTextField field4 = new JTextField();
				Object[] message = {
				    "Enter customer name:", field1,
				    "Enter customer surname:", field2,
				    "Enter customer phone:", field3,
				    "Enter sale date (dd.MM.YYYY):", field4};
				int option = JOptionPane.showConfirmDialog(null, message, "Complete new Sale's Information", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION)
				{
					//Save inputs into variables
					String customerName = field1.getText();
					String customerSurname = field2.getText();
					String customerPhone = field3.getText();
					String dateString = field4.getText();
					while(!validateDateInput(dateString)) {
						dateString = JOptionPane.showInputDialog("Insert Valid Date (dd.MM.YYYY):",null);
						if(dateString == null) { dateString = ""; }
					}
					Date saleDate = stringToDate(dateString);
					Double saleCost = product.getPrice() - (product.getPrice()*product.getDiscount());

					//Update Product Catalog
					CatalogLoader.productsCatalog.put(product, CatalogLoader.productsCatalog.get(product)-1);
					tabbedPane.setComponentAt(0, makeProductList());

					//Add Sale to Sales' Catalog
					CatalogLoader.salesCatalog.add(new Sale(CatalogLoader.saleCode,product,customerName,customerSurname,customerPhone,saleDate,saleCost));
					tabbedPane.setComponentAt(2, makeSaleList());

					//Increment of the sale code
					CatalogLoader.saleCode++;
					
					JOptionPane.showMessageDialog(null, "The final cost is: " + saleCost, "Sale Complete",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	//Method that sets CheckoutButton's properties and updates sale list tab
	protected static void setupCheckoutButton(JButton btnCheckout){
		btnCheckout.setEnabled(false);
		btnCheckout.setToolTipText("Click to checkout an order.");
		btnCheckout.setIcon(createImageIcon("images/checkout.png"));
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order anOrder = CatalogLoader.ordersCatalog.get(clickIndex);
				CatalogLoader.ordersCatalog.get(clickIndex).setOrderStatus("COMPLETE");
				String dateString = JOptionPane.showInputDialog(null, "Insert Sale Date");
				while(!validateDateInput(dateString)) {
					dateString = JOptionPane.showInputDialog("Insert Valid Sale Date (dd.MM.YYYY):",null);
					if(dateString == null) { dateString = ""; }
				}
				Date date = stringToDate(dateString);
				CatalogLoader.salesCatalog.add(new Sale(CatalogLoader.saleCode,anOrder.getOrderProduct(),anOrder.getCustomerName(),anOrder.getCustomerSurname(),anOrder.getCustomerPhone(),date,anOrder.getOrderCost()));
				tabbedPane.setComponentAt(2,makeSaleList());
				
				//Increment of the sale code
				CatalogLoader.saleCode++;
				
				JOptionPane.showMessageDialog(null, "Checkout Complete.", "Order Update", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	protected static void setupExitButton(JButton btnExit){
		btnExit.setToolTipText("Exit/Close Program");
		btnExit.setIcon(createImageIcon("images/exit.png"));
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	
	//Method that sets SearchButton's properties
	protected static void setupSearchButton(JButton btnSearch){
		btnSearch.setIcon(createImageIcon("images/search.png"));
		btnSearch.setToolTipText("Search for orders/sales by Customer's Name");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JList list;
				String name = JOptionPane.showInputDialog(null, "Insert Customer's Name (or Surname): ", "Search", JOptionPane.QUESTION_MESSAGE);
				if(name != null && !name.isEmpty()) {
					if (tabIndex == 1){
						list = searchOrderList(CatalogLoader.ordersCatalog, name);
						if (list.getModel().getSize() == 0){
							JOptionPane.showMessageDialog(null, "Name Not Found.");
						}else{
							JOptionPane.showMessageDialog(null, list, "Search Results", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					if (tabIndex == 2){
						list = searchSaleList(CatalogLoader.salesCatalog, name);
						if (list.getModel().getSize() == 0){
							JOptionPane.showMessageDialog(null, "Name Not Found.");
						}else{
							JOptionPane.showMessageDialog(null, list, "Search Results", JOptionPane.INFORMATION_MESSAGE);
						}
					}	
				}
			}
		});
	}
	
	//Returns Products based on the category and sub category chosen
	protected static ArrayList<Product> filterDevices(int cat, int subCat) 
	{
		ArrayList<Product> devices = new ArrayList<Product>();
		
		Enumeration<Product> k = CatalogLoader.productsCatalog.keys();
		
		while(k.hasMoreElements()) {
			Product aKey = (Product) k.nextElement();
			
			if((aKey.getCategory().intValue()==cat) && (aKey.getSubCategory().intValue()==subCat)) {
				devices.add(aKey);
			}
		}
		
		return devices;
	}
	
	//Method that converts a string to date
	protected static Date stringToDate(String aDateString) {
		StringTokenizer st = new StringTokenizer(aDateString,".");
		int[] date_parts = new int[3];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			date_parts[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		GregorianCalendar cal = new GregorianCalendar(date_parts[2],date_parts[1]-1,date_parts[0]);
		
		return cal.getTime();
	}
	
	//Method that searches the OrderList and then makes a sorted list with the results
	protected static JList searchOrderList(ArrayList<Order> array, String name){
		int i;
		DefaultListModel model = new DefaultListModel();
		for(i = 0; i < array.size(); i++){
			String customerName = array.get(i).getCustomerName() + " " + array.get(i).getCustomerSurname();
				if (customerName.toLowerCase().contains(name.toLowerCase())){
					model.addElement(CatalogLoader.ordersCatalog.get(i));
				}
			}
		sortedList = new JList(model);
		sortedList.setCellRenderer(new OrderRenderer());
		sortedList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        JList list = (JList)e.getSource();
		        if(e.getClickCount() == 1){
		        	clickIndex = list.locationToIndex(e.getPoint());
		        	if(CatalogLoader.ordersCatalog.get(clickIndex).getOrderStatus().equals("IN PROGRESS")){
			        	btnCheckout.setEnabled(true);
		        	}else{
		        		btnCheckout.setEnabled(false);
		        	}
		        }else if (e.getClickCount() == 2) {
		        	int clickIndex = list.locationToIndex(e.getPoint());
		            JOptionPane.showMessageDialog(null,CatalogLoader.ordersCatalog.get(clickIndex).toString());
		            }
		        }
		    });
		return  sortedList;
	}
	
	//Method that searches the SaleList and then makes a sorted list with the results
	protected static JList searchSaleList(ArrayList<Sale> array, String name){
		int i;
		DefaultListModel model = new DefaultListModel();
		for(i = 0; i < array.size(); i++){
			String customerName = array.get(i).getCustomerName() + " " + array.get(i).getCustomerSurname();
				if (customerName.toLowerCase().contains(name.toLowerCase())){
					model.addElement(CatalogLoader.salesCatalog.get(i));
				}
			}
		sortedList = new JList(model);
		sortedList.setCellRenderer(new SaleRenderer());
		sortedList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        JList list = (JList)e.getSource();
		        if (e.getClickCount() == 2) {
		        	int clickIndex = list.locationToIndex(e.getPoint());
		            JOptionPane.showMessageDialog(null,CatalogLoader.salesCatalog.get(clickIndex).toString());
		            }
		        }
		    });
		return sortedList;
	}
	
	//Method that validates Date Input
    protected static boolean validateDateInput(String input) {
        boolean isInputValid = false;
        
        if(input.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")){
        	isInputValid = true;
        }
        
        return isInputValid;
    }
}