public class Product
{
	
	private Integer code;
	private Integer modelYear;
	private Integer category;
	private Integer subCategory;
	private String modelName;
	private String manufacturer;
	private Double price;
	private Double discount;
	private String iconName;
	
	public Product()
	{
		this.code = null;
		this.modelName = null;
		this.modelYear = null;
		this.manufacturer = null;
		this.price = null;
		this.category = null;
		this.subCategory = null;
		this.discount = null;
		this.iconName = null;
	}
	
	public Product(int code, String modelName, int modelYear,
			String manufacturer, double price, int category,int subCategory,
			double discount, String iconName)
	{
		this.code=code;
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.subCategory = subCategory;
		this.discount = discount;
		this.iconName = iconName;
	}
	
	public int getCode()
	{
		return code;
	}
	
	public void setCode(int code) 
	{
		this.code = code;
	}
	
	public String getModel()
	{
		return modelName;
	}
	
	public void setModel(String modelName) 
	{
		this.modelName = modelName;
	}
	
	public int getYear()
	{
		return modelYear;
	}
	
	public void setYear(int modelYear)
	{
		this.modelYear = modelYear;
	}
	
	public String getManufacturer()
	{
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(Double price) 
	{
		this.price = price;
	}
	
	public Integer getCategory()
	{
		return category;
	}
	
	public void setCategory(Integer category)
	{
		this.category = category;
	}
	
	public double getDiscount() 
	{
		return discount;
	}
	
	public void setDiscount(double discount) 
	{
		this.discount = discount;
	}
	
	public Integer getSubCategory() 
	{
		return subCategory;
	}
	
	public void setSubCategory(int subCategory) 
	{
		this.subCategory = subCategory;
	}
	
	public String getIconName()
	{
		return iconName;
	}
	
	public void setIconName(String iconName) 
	{
		this.iconName = iconName;
	}
	
	public String toString()
	{
		return "Product Details: " 
				+ "\nCategory: " + getCategory() 
				+ "\nSubCategory: " + getSubCategory() 
				+ "\nCode: " + getCode() 
				+ "\nModel: " + getModel() 
				+ "\nYear: " + getYear() 
				+ "\nManufacturer: " + getManufacturer() 
				+ "\nPrice: " + getPrice() 
				+ "\nDiscount: " + getDiscount();
	}
	public String printTaggedDescription(){
		return "\tITEM\n"
				+"\t{\n"
				+"\t\tCODE " + this.code + "\n"
				+"\t\tMODEL_NAME " + this.modelName + "\n"
				+"\t\tMODEL_YEAR" + this.modelYear + "\n"
				+"\t\tMANUFACTURER " + this.manufacturer + "\n"
				+"\t\tPRICE " + this.price + "\n"
				+"\t\tITEM_CAT " + this.category + "\n"
				+"\t\tITEM_SUB_CAT " + this.subCategory + "\n"
				+"\t\tDISCOUNT " + this.discount + "\n"
				+"\t\tICON_NAME " + this.iconName + "\n";
	}	
}