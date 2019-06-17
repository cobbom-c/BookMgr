package top.ourck.beans;

public class TeacherTicket {

	private int id;
	private String ticket;
	private Teacher teacher;
	
	public TeacherTicket() {
		// TODO Auto-generated constructor stub
	}

	public TeacherTicket(int id, String ticket, Teacher teacher) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
