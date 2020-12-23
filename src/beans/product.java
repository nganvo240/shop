package beans;

public class product {
	private int id;
	private String name;
	private int price;
	private String detail;
	private String img;
	private String type_name;
	private int type_id;

public product() {
		
	}
	public product(int id, String name, int price, String detail, String img, int type_id )
	{
		super();
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setDetail(detail);
		this.setImg(img);
		this.setType_id(type_id);
	
	}
	public product(int id, String name, int price, String detail, String img, String type_name )
	{
		super();
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setDetail(detail);
		this.setImg(img);
		this.setType_name(type_name);

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	
	

}
