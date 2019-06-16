package top.ourck.beans;

public class Class {

	private int id;
	private String name;
	private String grade;
	private Major major;
	
	public Class() {
		// TODO Auto-generated constructor stub
	}

	public Class(int id, String name, String grade, Major major) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.major = major;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	
	
	
}
