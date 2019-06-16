package top.ourck.beans;

public class Admin {

	private int id;
	private String userName;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String userName, String pssword) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = pssword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pssword) {
		this.password = pssword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
