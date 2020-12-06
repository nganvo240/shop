package beans;

public class type {
	private String name;
	private int id;
	private String link;
public type() {
		
	}
	public type(String name, String link, int id )
	{
		super();
		this.setId(id);
		this.setName(name);
		this.setLink(link);
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
