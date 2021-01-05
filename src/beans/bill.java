package beans;

public class bill {
	private int id, customer, totalMoney, status;
	private String date;
	public bill( int customer, int totalMoney )
	{
		super();
		this.setCustomer(customer);
		this.setTotalMoney(totalMoney);
	}
	
	public bill(int id, int customer, int totalMoney, int status, String date )
	{
		super();
		this.setId(id);
		this.setCustomer(customer);
		this.setTotalMoney(totalMoney);
		this.setStatus(status);
		this.setDate(date);
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	} 
}
