package top.ourck.beans.util;

import top.ourck.beans.Admin;
import top.ourck.beans.Student;
import top.ourck.beans.Teacher;
import top.ourck.beans.UserType;

public class User {

	private int id;
	private String userName;
	private String password;
	private UserType type;
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(int id, String userName, String password, UserType type) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.type = type;
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

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
	
	
	// Wrapper method
	
	public static User wrap(Admin user) {
		return new User(user.getId(), user.getUserName(), user.getPassword(), UserType.ADMIN);
	}
	
	public static User wrap(Teacher user) {
		return new User(user.getId(), user.getUserName(), user.getPassword(), UserType.TEACHER);
	}
	
	public static User wrap(Student user) {
		return new User(user.getId(), user.getUserName(), user.getPassword(), UserType.STUDENT);
	}
}
