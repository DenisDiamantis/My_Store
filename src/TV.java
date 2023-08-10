public class TV extends Product
{
	
	private String type;
	private String[] ports;
	private String screenSize;
	private String resolution;
	
	public TV() 
	{
		super();
		this.type = null;
		this.screenSize = null;
		this.resolution = null;
		this.ports = null;
	}
	
	public TV(int code, String modelName, int modelYear,
			String manufacturer, double price, int category,int subCategory,
			double discount, String iconName, String type, String screenSize,
			String resolution, String[] ports) 
	{
		super(code,modelName,modelYear,manufacturer,price,category, subCategory, discount, iconName);
		this.type = type;
		this.screenSize = screenSize;
		this.resolution = resolution;
		this.ports = ports;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setPorts(String[] ports)
	{
		this.ports = ports;
	}
	
	public String[] getPorts()
	{
		return ports;
	}
	
	public String getScreenSize()
	{
		return screenSize;
	}
	
	public void setScreenSize(String screenSize) 
	{
		this.screenSize = screenSize;
	}
	
	public String getResolution()
	{
		return resolution;
	}
	
	public void setResolution(String resolution) 
	{
		this.resolution = resolution;
	}
	
	public String toString() 
	{
			String description = super.toString();
			
			description += "\nType: " + this.type + "\n"
							+"Screen size: " + this.screenSize + "\n"
							+"Resolution: " + this.resolution + "\n"
							+"Ports:";
			
			for(String port : this.ports)
			{ description += " |"+port; }
			
			description += "\n";
			
			return description;
	}
	public String printTaggedDescription(){
		String description = null;
		for(String port : this.ports)
		{ description += " |"+port; }
		return super.printTaggedDescription()
				+"\t\tITEM_TYPE " + this.type + "\n"
				+"\t\tSCREEN_SIZE " + this.screenSize + "\n"
				+"\t\tRESOLUTION " + this.resolution + "\n"
				+"\t\tPORTS " + description + "\n";
	}	
}