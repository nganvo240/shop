package beans;

public class bill_infor {
	private int bill_id, product_id, quantity;
	public bill_infor(int bill_id, int product_id, int quantity )
	{
		super();
		this.setBill_id(bill_id);
		this.setProduct_id(product_id);
		this.setQuantity(quantity);
	}
	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
