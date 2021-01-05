package beans;

public class customer {
	private String name, address, tel, username ;
	
	public customer( String name, String address, String tel, String username )
	{
		super();
		this.setName(username);
		this.setAddress(address);
		this.setTel(tel);
		this.setUsername(username);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
