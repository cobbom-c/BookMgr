package top.ourck.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import top.ourck.beans.UserType;
import top.ourck.beans.util.User;
import top.ourck.beans.util.UserHolder;

/**
 * 用于验证用户是否具有教师系统访问权的Interceptor。<br>
 * 验证原理为：处理该请求的线程ThreadLocal中是否具有User实体。<br>
 * 如果有，取出，并察看其用户类型。<br>
 * 该实体是由前置拦截器{@link RememberedUserInterceptor}置入的。
 * @author ourck
 */
@Component
public class AdminAuthInterceptor implements HandlerInterceptor {

	@Autowired
	private UserHolder userHolder;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean passFlag = false;
		User user = userHolder.getUser();
		String requestUri = request.getRequestURI();
		if(user == null) { // If this user haven't login yet
			passFlag = false;
		}
		else if(!user.getType().equals(UserType.ADMIN)){ // If this user isn't a teacher
			passFlag = false;
		}
		else {
			passFlag = true;
		}
		
		if(!passFlag) {
			response.sendRedirect("/login/auth?target=" + requestUri);
		}
		
		return passFlag;
	}

}
