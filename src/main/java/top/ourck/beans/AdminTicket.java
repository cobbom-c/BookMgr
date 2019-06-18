package top.ourck.beans;

import java.util.Date;

public class AdminTicket {

	private int id;
	private String ticket;
	private Admin admin;
	private Date expired;
	private int status;
	
	public AdminTicket() {
		// TODO Auto-generated constructor stub
	}

	public AdminTicket(int id, String ticket, Admin admin, Date expired, int status) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.admin = admin;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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
	
	
}
