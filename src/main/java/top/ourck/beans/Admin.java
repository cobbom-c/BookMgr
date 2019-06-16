package top.ourck.beans;

public class Admin {

	private int id;
	private String userName;
	private String pssword;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String userName, String pssword) {
		super();
		this.id = id;
		this.userName = userName;
		this.pssword = pssword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPssword() {
		return pssword;
	}

	public void setPssword(String pssword) {
		this.pssword = pssword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
