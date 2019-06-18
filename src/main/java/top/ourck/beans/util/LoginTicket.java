package top.ourck.beans.util;

import java.util.Date;

import top.ourck.beans.AdminTicket;
import top.ourck.beans.StudentTicket;
import top.ourck.beans.TeacherTicket;


public class LoginTicket {

	private int id;
	private String ticket;
	private User user;
	private Date expired;
	private int status;
		
	public LoginTicket() {
		// TODO Auto-generated constructor stub
	}


	public LoginTicket(int id, String ticket, User user, Date expired, int status) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.user = user;
		this.expired = expired;
		this.status = status;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	// Wrapper method
	
	public static LoginTicket wrap(AdminTicket t) {
		LoginTicket lt = new LoginTicket();
		lt.setId(t.getId());
		lt.setExpired(t.getExpired());
		lt.setStatus(t.getStatus());
		lt.setTicket(t.getTicket());
		lt.setUser(User.wrap(t.getAdmin()));
		return lt;
	}
	
	public static LoginTicket wrap(TeacherTicket t) {
		LoginTicket lt = new LoginTicket();
		lt.setId(t.getId());
		lt.setExpired(t.getExpired());
		lt.setStatus(t.getStatus());
		lt.setTicket(t.getTicket());
		lt.setUser(User.wrap(t.getTeacher()));
		return lt;
	}
	
	public static LoginTicket wrap(StudentTicket t) {
		LoginTicket lt = new LoginTicket();
		lt.setId(t.getId());
		lt.setExpired(t.getExpired());
		lt.setStatus(t.getStatus());
		lt.setTicket(t.getTicket());
		lt.setUser(User.wrap(t.getStudent()));
		return lt;
	}
}
