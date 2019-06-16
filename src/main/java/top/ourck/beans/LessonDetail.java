package top.ourck.beans;

public class LessonDetail {

	private int id;
	private String userName;
	private String password;
	private LessonDetail lessonDetail;
	
	public LessonDetail() {
		// TODO Auto-generated constructor stub
	}

	public LessonDetail(int id, String userName, String password, LessonDetail lessonDetail) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.lessonDetail = lessonDetail;
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

	public LessonDetail getLessonDetail() {
		return lessonDetail;
	}

	public void setLessonDetail(LessonDetail lessonDetail) {
		this.lessonDetail = lessonDetail;
	}
	
	
}
