public class PortableConsole extends Product
{
	
	private String type;
	private String processor;
	private String graphics;
	private String sound;
	private String storageCapacity;
	
	public PortableConsole() 
	{
		super();
		this.type = null;
		this.processor = null;
		this.graphics = null;
		this.sound = null;
		this.storageCapacity = null;
	}
	
	public PortableConsole(int code, String modelName, int modelYear,
			String manufacturer, double price, int category,int subCategory,
			double discount, String iconName, String type, String processor,
			String graphics, String sound, String storageCapacity)
	{
		super(code,modelName,modelYear,manufacturer,price,category, subCategory, discount, iconName);
		this.type = type;
		this.processor = processor;
		this.graphics = graphics;
		this.sound = sound;
		this.storageCapacity = storageCapacity;
	}

	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	public String getProcessor()
	{
		return processor;
	}
	public void setProcessor(String processor)
	{
		this.processor = processor;
	}
	public String getGraphics() 
	{
		return graphics;
	}
	public void setGraphics(String graphics)
	{
		this.graphics = graphics;
	}
	public String getSound() 
	{
		return sound;
	}
	public void setSound(String sound)
	{
		this.sound = sound;
	}
	public String getStorageCapacity() 
	{
		return storageCapacity;
	}
	public void setStorageCapacity(String storageCapacity) 
	{
		this.storageCapacity = storageCapacity;
	}
	
	public String toString()
	{
		return super.toString()
			+ "\nType: " + getType() 
			+ "\nProcessor: " + getProcessor() 
			+ "\nGraphics: " + getGraphics() 
			+ "\nSound: " + getSound() 
			+ "\nHDD: " + getStorageCapacity();
	}
	public String printTaggedDescription(){
		return super.printTaggedDescription()
				+"\t\tITEM_TYPE " + this.type + "\n"
				+"\t\tPROCESSOR " + this.processor + "\n"
				+"\t\tGRAPHICS " + this.graphics + "\n"
				+"\t\tSOUND " + this.sound + "\n"
				+"\t\tHDD " + this.storageCapacity + "\n";
	}	
}