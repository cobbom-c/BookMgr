package top.ourck.beans;

import java.util.Date;

public class TeacherTicket {

	private int id;
	private String ticket;
	private Teacher teacher;
	private Date expired;
	private int status;

	public TeacherTicket() {
		// TODO Auto-generated constructor stub
	}

	public TeacherTicket(int id, String ticket, Teacher teacher) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.teacher = teacher;
	}

	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
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
