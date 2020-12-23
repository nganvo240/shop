package beans;

public class product_detail {
	private int id;
	private int id_product;
	private int size;
	private int quantity;
	public product_detail() {

	}
	public product_detail(int size) {
		this.setSize(size);
	}
	public product_detail(int id, int id_product,int size,int quantity)
	{
		super();
		this.setId(id);
		this.setId_product(id_product);
		this.setQuantity(quantity);
		this.setSize(size);
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
