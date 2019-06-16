package top.ourck.beans;

public class Student {

	private int id;
	private String userName;
	private String password;
	private StudentDetail studentDetail;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String userName, String password, StudentDetail studentDetail) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.studentDetail = studentDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}
	
}
