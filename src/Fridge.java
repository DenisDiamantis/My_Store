public class Fridge extends Product
{
	
	private String type;
	private String energyClass;
	private String refrigeratorCapacity;
	private String freezerCapacity;
	
	public Fridge() 
	{
		super();
		this.type = null;
		this.energyClass = null;
		this.refrigeratorCapacity = null;
		this.freezerCapacity = null;
	}
	
	public Fridge(int code, String modelName, int modelYear,
			String manufacturer, double price, int category,int subCategory,
			double discount, String iconName, String type, String energyClass,
			String refrigeratorCapacity, String freezerCapacity	) 
	{
		super(code,modelName,modelYear,manufacturer,price,category, subCategory, discount, iconName);
		this.type = type;
		this.energyClass = energyClass;
		this.refrigeratorCapacity = refrigeratorCapacity;
		this.freezerCapacity = freezerCapacity;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getEnergyClass() 
	{
		return energyClass;
	}
	
	public void setEnergyClass(String energyClass) 
	{
		this.energyClass = energyClass;
	}
	
	public String getRefrigeratorCapacity() 
	{
		return refrigeratorCapacity;
	}
	
	public void setRefrigeratorCapacity(String refrigeratorCapacity) 
	{
		this.refrigeratorCapacity = refrigeratorCapacity;
	}
	
	public String getFreezerCapacity()
	{
		return freezerCapacity;
	}
	
	public void setFreezerCapacity(String freezerCapacity) 
	{
		this.freezerCapacity = freezerCapacity;
	}
	
	public String toString()
	{
		return super.toString()
				+"\nType: " + getType() 
				+ "\nEnergy Class: " + getEnergyClass() 
				+ "\nRefrigerator Capacity: " + getRefrigeratorCapacity()  
				+ "\nFreezer Capacity: " + getFreezerCapacity();
	}
	public String printTaggedDescription(){
		return super.printTaggedDescription()
				+"\t\tITEM_TYPE " + this.type + "\n"
				+"\t\tENERGY_CLASS " + this.energyClass + "\n"
				+"\t\tREFRIGERATOR_CAPACITY " + this.refrigeratorCapacity + "\n";
	}	
}