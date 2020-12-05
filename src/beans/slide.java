package beans;

public class slide {
	private int id;
	private String img;
	private String title;
	private String description;
	
	public slide() {
		
	}
	public slide(int id, String img, String title,String description )
	{
		super();
		this.setId(id);
		this.setImg(img);
		this.setTitle(title);
		this.setDescription(description);
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
