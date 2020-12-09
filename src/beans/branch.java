package beans;

public class branch {
	private String name;
	private int id;
public branch() {
		
	}
	public branch(String name,  int id )
	{
		super();
		this.setId(id);
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
