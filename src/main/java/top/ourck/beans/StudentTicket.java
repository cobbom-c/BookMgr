package top.ourck.beans;

public class StudentTicket {

	private int id;
	private String ticket;
	private Student student;
	
	public StudentTicket() {
		// TODO Auto-generated constructor stub
	}

	public StudentTicket(int id, String ticket, Student student) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.student = student;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
