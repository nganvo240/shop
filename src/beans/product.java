package beans;

public class product {
	private int id;
	private String name;
	private int price;
	private String status;
	private String detail;
	private int price_new;
	private String img;
public product() {
		
	}
	public product(int id, String name, int price, String status, String detail, int price_new, String img )
	{
		super();
		this.setId(id);
		this.setName(name);
		this.setPrice(price_new);
		this.setStatus(status);
		this.setDetail(detail);
		this.setPrice_new(price_new);
		this.setImg(img);
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice_new() {
		return price_new;
	}
	public void setPrice_new(int price_new) {
		this.price_new = price_new;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}