package beans;

public class user {
	private String username;
	private String password;
	private String email;
	private int role;
	
public user() {
		
	}
	public user(String username, String password, String email, int role )
	{
		super();
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setRole(role);
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

}
