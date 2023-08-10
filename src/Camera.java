public class Camera extends Product{
	
	private String type;
	private String megapixel;
	private String opticalZoom;
	private String digitalZoom;
	private String screenSize;
	
	public Camera()
	{
		super();
		this.type = null;
		this.megapixel = null;
		this.opticalZoom = null;
		this.digitalZoom = null;
		this.screenSize = null;
	}
	
	public Camera(int code, String modelName, int modelYear,
			String manufacturer, double price, int category,int subCategory,
			double discount, String iconName, String type, String megapixel,
			String opticalZoom, String digitalZoom, String screenSize)
		{
			super(code, modelName, modelYear, manufacturer, price, category, subCategory, discount, iconName);
			this.type = type;
			this.megapixel = megapixel;
			this.opticalZoom = opticalZoom;
			this.digitalZoom = digitalZoom;
			this.screenSize = screenSize;
		}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getMegapixel() 
	{
		return megapixel;
	}
	
	public void setMegapixel(String megapixel) 
	{
		this.megapixel = megapixel;
	}
	
	public String getOpticalZoom() 
	{
		return opticalZoom;
	}
	
	public void setOpticalZoom(String opticalZoom) 
	{
		this.opticalZoom = opticalZoom;
	}
	
	public String getDigitalZoom() 
	{
		return digitalZoom;
	}
	
	public void setDigitalZoom(String digitalZoom) 
	{
		this.digitalZoom = digitalZoom;
	}
	
	public String getScreenSize() 
	{
		return screenSize;
	}
	
	public void setScreenSize(String screenSize) 
	{
		this.screenSize = screenSize;
	}
	
	public String toString()
	{	
		return  super.toString()
				+"\nType: " + getType() 
				+ "\nMegapixel: " + getMegapixel() 
				+ "\nVisualZoom: " + getOpticalZoom() 
				+ "\nDigitalZoom: " + getDigitalZoom() 
				+ "\nInches: " + getScreenSize();
	}
	public String printTaggedDescription(){
		return super.printTaggedDescription()
				+"\t\tITEM_TYPE " + this.type + "\n"
				+"\t\tMEGAPIXEL " + this.megapixel + "\n"
				+"\t\tVISUAL_ZOOM " + this.opticalZoom + "\n"
				+"\t\tDIGITAL_ZOOM " + this.digitalZoom + "\n"
				+"\t\tSCREEN_SIZE " + this.screenSize + "\n";
	}	
}
	