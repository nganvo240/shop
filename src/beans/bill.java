package beans;

import java.sql.Date;

public class bill {
	private String status; 
	private int id, totalMoney,customer_id;
	private Date date;
	public bill()
	{

	}
	public bill(int customer_id, int totalMoney)
	{
		super();
		this.setTotalMoney(totalMoney);
		this.setCustomer_id(customer_id);
	}
	public bill(Date date, int id, int customer_id, int totalMoney , String status)
	{
		super();
		this.setDate(date);
		this.setId(id);
		this.setTotalMoney(totalMoney);
		this.setCustomer_id(customer_id);
	}
	
	
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
