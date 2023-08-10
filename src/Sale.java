import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sale{
	
	private Integer saleCode;
	private Product saleProduct;
	private String customerName;
	private String customerSurname;
	private String customerPhone;
	private Date saleDate;
	private Double saleCost;
	
	public Sale() {
		this.saleCode = null;
		this.saleProduct = null;
		this.customerName = null;
		this.customerSurname = null;
		this.customerPhone = null;
		this.saleDate = null;
		this.saleCost = null;
	}
	
	public Sale(int saleCode,Product saleProduct, String customerName,String customerSurname,String customerPhone,Date saleDate,
			double saleCost)
	{
		this.saleCode = saleCode;
		this.saleProduct = saleProduct;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerPhone = customerPhone;
		this.saleDate = saleDate;
		this.saleCost = saleCost;
	}

	public int getSaleCode() {
		return saleCode;
	}
	public void setSaleCode(int saleCode) {
		this.saleCode = saleCode;
	}
	public Product getSaleProduct() {
		return saleProduct;
	}
	public void setSaleProduct(Product saleProduct) {
		this.saleProduct = saleProduct;
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
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Double getSaleCost() {
		return saleCost;
	}
	public void setSaleCost(Double saleCost) {
		this.saleCost = saleCost;
	}
	public String dateToString(Date aDate) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(aDate);
		
		return cal.get(Calendar.DAY_OF_MONTH)+ "." + (cal.get(Calendar.MONTH)+1) + "." + cal.get(Calendar.YEAR);
	}
	public String toString(){
		return "Sale Code: " + getSaleCode()
				+"\n" + getSaleProduct()
				+"\nCustomer Name: " + getCustomerName()
				+"\nCustomer Surname: " + getCustomerSurname()
				+"\nCustomer Phone: " + getCustomerPhone()
				+"\nDate Of Sale: " + dateToString(getSaleDate())
				+"\nFinal Cost: " + getSaleCost();
	}
	public String printTaggedDescription(){
		return "\tSALE\n"
				+"\t{\n"
				+"\t\tSALE_CODE " + this.saleCode + "\n"
				+"\t\tSALE_DEVICE_CODE " + this.saleProduct.getCode() + "\n"
				+"\t\tCUSTOMER_NAME " + this.customerName + "\n"
				+"\t\tCUSTOMER_SURNAME " + this.customerSurname + "\n"
				+"\t\tCUSTOMER_PHONE " + this.customerPhone + "\n"
				+"\t\tSALE_DATE " + dateToString(this.saleDate) + "\n"
				+"\t\tSALE_COST " + this.saleCost + "\n"
				+"\t}\n";
	}	
}
