import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Order {
	
	private Integer orderCode;
	private Product orderProduct;
	private String customerName;
	private String customerSurname;
	private String customerPhone;
	private Date orderDate;
	private Date orderETA;
	private Double orderCost;
	private String orderStatus;
	
	public Order() {
		this.orderCode = null;
		this.orderProduct = null;
		this.customerName = null;
		this.customerSurname = null;
		this.customerPhone = null;
		this.orderDate = null;
		this.orderETA = null;
		this.orderCost = null;
		this.orderStatus = null;
	}
	
	public Order(int orderCode, Product orderProduct, String customerName,String customerSurname,String customerPhone, Date orderDate, 
			Date orderETA, double orderCost, String orderStatus)
	{
		this.orderCode = orderCode;
		this.orderProduct = orderProduct;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerPhone = customerPhone;
		this.orderDate = orderDate;
		this.orderETA = orderETA;
		this.orderCost = orderCost;
		this.orderStatus = orderStatus;
	}
	
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public Product getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(Product orderProduct) {
		this.orderProduct = orderProduct;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderETA() {
		return orderETA;
	}
	public void setOrderETA(Date orderETA) {
		this.orderETA = orderETA;
	}
	public Double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String dateToString(Date aDate) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(aDate);
		
		return cal.get(Calendar.DAY_OF_MONTH)+ "." + (cal.get(Calendar.MONTH)+1) + "." + cal.get(Calendar.YEAR);
	}
	public String toString(){
		return "Code: " + getOrderCode() 
		+ "\n" + getOrderProduct()
		+ "\nCustomer's Name: " + getCustomerName() 
		+ "\nCustomer's Surname: " + getCustomerSurname() 
		+ "\nCustomer's Phone: " + getCustomerPhone() 
		+ "\nOrder Date: " + dateToString(getOrderDate())
		+ "\nOrder ETA: " + dateToString(getOrderETA()) 
		+ "\nOrder Cost: " + getOrderCost() 
		+ "\nOrder Status: " + getOrderStatus();
	}
	public String printTaggedDescription(){
		return "\tORDER\n"
				+"\t{\n"
				+"\t\tORDER_CODE " + this.orderCode + "\n"
				+"\t\tORDER_DEVICE_CODE " + this.orderProduct.getCode() + "\n"
				+"\t\tCUSTOMER_NAME " + this.customerName + "\n"
				+"\t\tCUSTOMER_SURNAME " + this.customerSurname + "\n"
				+"\t\tCUSTOMER_PHONE " + this.customerPhone + "\n"
				+"\t\tORDER_DATE " + dateToString(this.orderDate) + "\n"
				+"\t\tORDER_ETA " + dateToString(this.orderETA) + "\n"
				+"\t\tORDER_COST " + this.orderCost + "\n"
				+"\t\tORDER_STATUS " + this.orderStatus + "\n"
				+"\t}\n";
	}	
}
