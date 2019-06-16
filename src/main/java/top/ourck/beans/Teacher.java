package top.ourck.beans;

public class Teacher {

	private int id;
	private String userName;
	private String password;
	private TeacherDetail teacherDetail;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String username, String password, TeacherDetail teacherDetail) {
		super();
		this.id = id;
		this.userName = username;
		this.password = password;
		this.teacherDetail = teacherDetail;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public TeacherDetail getTeacherDetail() {
		return teacherDetail;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTeacherDetail(TeacherDetail teacherDetail) {
		this.teacherDetail = teacherDetail;
	}
	
	
}
