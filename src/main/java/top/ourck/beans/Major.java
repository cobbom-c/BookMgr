package top.ourck.beans;

public class Major {

	private int id;
	private String name;
	
	public Major() {
		// TODO Auto-generated constructor stub
	}
	
	public Major(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
