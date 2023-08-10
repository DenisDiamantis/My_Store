public class Player extends Product
{
	private String type;
	private String[] mediaFormat;
	
	public Player() 
	{
		super();
		this.type = null;
		this.mediaFormat = null;
	}
	
	public Player(int code, String modelName, int modelYear,
			String manufacturer, double price, int category,int subCategory,
			double discount, String iconName, String type,String[] mediaFormat)
	{
		super(code,modelName,modelYear,manufacturer,price,category, subCategory, discount, iconName);
		this.type = type;
		this.mediaFormat = mediaFormat;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
		
	public String[] getMediaFormat()
	{
		return mediaFormat;
	}
	
	public void setMediaFormat(String[] mediaFormat)
	{
		this.mediaFormat = mediaFormat;
	}
	
	public String toString()
	{
		
		String description = super.toString();
		
		description+= "\nType: " + getType() 
				     + "\nFormat:";
		for(String mediaFormat : this.mediaFormat)
		{ description += " |"+mediaFormat; }
		
		description += "\n";
		
		return description;
	}
	public String printTaggedDescription(){
		String description = null;
		for(String port : this.mediaFormat)
		{ description += " |"+port; }
		return super.printTaggedDescription()
				+"\t\tITEM_TYPE " + this.type + "\n"
				+"\t\tMEDIA_FORMAT " + description + "\n";
	}	
}