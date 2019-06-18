package top.ourck.beans.util;

import org.springframework.stereotype.Component;

@Component
public class UserHolder {
	private static ThreadLocal<User> userTl = new ThreadLocal<>();
	
	public User getUser() { return userTl.get(); }
	public void setUser(User user) { userTl.set(user); }
	
	/**
	 * ThreadLocal的变量必须手动释放 否则内存泄露!!!
	 * http://ifeve.com/%E4%BD%BF%E7%94%A8threadlocal%E4%B8%8D%E5%BD%93%E5%8F%AF%E8%83%BD%E4%BC%9A%E5%AF%BC%E8%87%B4%E5%86%85%E5%AD%98%E6%B3%84%E9%9C%B2/
	 */
	public void clear() {
		userTl.remove();
	} 
	
}
