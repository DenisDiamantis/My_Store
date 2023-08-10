public class WashingMachine extends Product
{
	
	private String energyClass;
	private String capacity;
	private String spinSpeed;
	
	public WashingMachine() {
		super();
		this.energyClass = null;
		this.capacity = null;
		this.spinSpeed = null;
	}
	
	public WashingMachine(int code, String modelName, int modelYear,
			String manufacturer, double price, int category,int subCategory,
			double discount, String iconName, String energyClass, String capacity,
			String spinSpeed)
	{
		super(code,modelName,modelYear,manufacturer,price,category, subCategory, discount, iconName);
		this.energyClass = energyClass;
		this.capacity = capacity;
		this.spinSpeed = spinSpeed;
	}
	
	public String getEnergyClass() 
	{
		return energyClass;
	}
	
	public void setEnergyClass(String energyClass) 
	{
		this.energyClass = energyClass;
	}
	
	public String getCapacity() 
	{
		return capacity;
	}
	
	public void setCapacity(String capacity) 
	{
		this.capacity = capacity;
	}
	
	public String getSpinSpeed()
	{
		return spinSpeed;
	}
	
	public void setSpinSpeed(String spinSpeed)
	{
		this.spinSpeed = spinSpeed;
	}

	public String toString()
	{
		return  super.toString()
				+ "\nEnergy Class: " + getEnergyClass()
				+ "\nCapacity: " + getCapacity()
				+ "\nSpin Speed: " + getSpinSpeed();
	}
	public String printTaggedDescription(){
		return super.printTaggedDescription()
				+"\t\tENERGY_CLASS " + this.energyClass + "\n"
				+"\t\tCAPACITY " + this.capacity + "\n"
				+"\t\tSPIN_SPEED " + this.spinSpeed + "\n";
	}	
	
}
