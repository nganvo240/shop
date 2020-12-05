package beans;

public class slide {
	private int id;
	private String img;
	public slide() {
		
	}
	public slide(int id, String img)
	{
		super();
		this.setId(id);
		this.setImg(img);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
