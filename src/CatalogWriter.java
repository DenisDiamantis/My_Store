import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class CatalogWriter {
	
	public static void writeProductsCatalog(Hashtable<Product, Integer> productsCatalog, String filePath){
		String productData = "ITEM_LIST\n{\n";
		
		Enumeration<Product> products = CatalogLoader.productsCatalog.keys();
		
		while(products.hasMoreElements()) {
			Product aProduct = products.nextElement();
			productData += aProduct.printTaggedDescription();
			productData += "\t\tQUANTITY " + CatalogLoader.productsCatalog.get(aProduct) + "\n\t}\n";
		}
		productData += "}";
		
		writeCatalogFile(filePath,productData);
		
		JOptionPane.showMessageDialog(null,"Products Catalog Saved");
	}
	public static void writeOrdersCatalog(ArrayList<Order> ordersCatalog, String filePath){
		String orderData = "ORDER_LIST\n{\n";
		
		Order anOrder;
		Iterator<Order> ordersIterator = ordersCatalog.iterator();
		while(ordersIterator.hasNext()) {
			anOrder = ordersIterator.next();
			orderData += anOrder.printTaggedDescription();
		}
		orderData += "}";
		
		writeCatalogFile(filePath,orderData);
		
		JOptionPane.showMessageDialog(null,"Orders Catalog Saved");
	}
	
	public static void writeSalesCatalog(ArrayList<Sale> salesCatalog, String filePath){
		String saleData = "SALE_LIST\n{\n";
		
		Sale aSale;
		Iterator<Sale> salesIterator = salesCatalog.iterator();
		while(salesIterator.hasNext()) {
			aSale = salesIterator.next();
			saleData += aSale.printTaggedDescription();
		}
		saleData += "}";
		
		writeCatalogFile(filePath,saleData);
		
		JOptionPane.showMessageDialog(null,"Sales Catalog Saved");
	}
	
    public static void writeCatalogFile(String filePath, String data) {
        try {
        	BufferedWriter os = new BufferedWriter(new FileWriter(filePath));
            os.write(data);
            os.flush();
            os.close();
            
            System.out.println("\n");
            System.out.println("Catalog file " + filePath + " saved successfully!");
        } catch(Exception e) {
        	System.out.println("\n");
        	System.out.println("Error saving file " + filePath + " - " + e.toString());
        }
    }
}
