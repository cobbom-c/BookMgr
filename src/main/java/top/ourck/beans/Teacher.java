package top.ourck.beans;


public class Teacher {

	private int id;
	private String userNamel;
	private String password;
	private TeacherDetail teacherDetail;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String userNamel, String password, TeacherDetail teacherDetail) {
		super();
		this.id = id;
		this.userNamel = userNamel;
		this.password = password;
		this.teacherDetail = teacherDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNamel() {
		return userNamel;
	}

	public void setUserNamel(String userNamel) {
		this.userNamel = userNamel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TeacherDetail getTeacherDetail() {
		return teacherDetail;
	}

	public void setTeacherDetail(TeacherDetail teacherDetail) {
		this.teacherDetail = teacherDetail;
	}
	
	
}
