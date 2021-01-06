package beans;

public class ad {
	private String username;
	private String password;
	private String email;
public ad() {
		
	}
	public ad(String username, String password, String email )
	{
		super();
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
