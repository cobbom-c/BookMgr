package top.ourck.beans;

public class StudentDetail {

	private int id;
	private String name;
	private String hometown;
	private Class clazz;
	
	public StudentDetail() {
		// TODO Auto-generated constructor stub
	}

	public StudentDetail(int id, String name, String hometown, Class clazz) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.clazz = clazz;
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
}
