package top.ourck.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import top.ourck.beans.util.UserHolder;

/**
 * 用于验证用户是否成功登陆的Interceptor。<br>
 * 验证原理为：处理该请求的线程ThreadLocal中是否具有User实体。<br>
 * 该实体是由前置拦截器{@link UserAuthInterceptor}置入的。
 * @author ourck
 */
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Autowired
	private UserHolder userHolder;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(userHolder.getUser() == null) {
			String requestUri = request.getRequestURI();
			response.sendRedirect("/login/auth?target=" + requestUri);
			return false;
		}
		return true;
	}

}
