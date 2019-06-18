package top.ourck.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import top.ourck.beans.UserType;
import top.ourck.beans.util.User;
import top.ourck.beans.util.UserHolder;
import top.ourck.service.LoginTicketService;

/**
 * 用于获取用户ticket并检查是否有效的Interceptor。
 * 工作流程为：
 * <ol>
 * <li>取出ticket；</li>
 * <li>校验ticket；</li>
 * <li>如果通过，向处理该请求的线程的ThreadLocal放入通过验证的用户实体U。</li>
 * </ol>
 * 上述U将被用于{@link LoginCheckInterceptor}中的二次校验。
 * <br><br>
 * TODO 每个角色一套机制，这不是一个良好的设计。<br>
 * 用户有三种：学生，老师，和管理员<br>
 * 虽然说不同角色的Interceptor分别映射到不同的URL路径上去，
 * 但万一日后需求变动，新增一种用户，除了变动数据库表（同时新增实体表和ticket表！）用户实体和Ticket实体的Bean、DAO、Service之外，
 * 还要变动Interceptor。
 * @author ourck
 *
 */
@Component
public class UserAuthInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * <b>为什么要使用ThreadLocal存储待使用的User？</b>
	 * <br>
	 * <ul>
	 * <li>
	 * 因为不止一个线程工作在服务器上，
	 * 而又有“每个线程处理自己的登陆会话”这一需求，
	 * 所以使用线程自己的ThreadLocal来存储User对象。
	 * </li>
	 * 
	 * <li>
	 * 而与此同时，作为@Component的Interceptor是单例的。
	 * 这样直接搞一个共享的User变量的话很不线程安全。
	 * </li>
	 * </ul>
	 */
	@Autowired
	private UserHolder userHolder;

	@Autowired
	private LoginTicketService ltService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) throws Exception {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) return true;
		
		for(Cookie ck : cookies) {
			if(ck.getName().equals("ticket")) {
				// 查三遍库来进行ticket有效性验证。 HINT 善用短路运算！
				// FIXME 这里有个问题，万一两张表里边的ticket都一样的话？不过概率很小就是了。
				User user = null;
				if((user = ltService.validateTicket(UserType.STUDENT, ck.getValue())) != null ||
					(user = ltService.validateTicket(UserType.TEACHER, ck.getValue())) != null || 
					(user = ltService.validateTicket(UserType.ADMIN, ck.getValue())) != null) {
					userHolder.setUser(user);
					break;
				}
			}
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
						   HttpServletResponse response,
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		User user = userHolder.getUser();
		if(modelAndView != null && user != null) {
			modelAndView.addObject("verifiedUser", user);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		userHolder.clear();
	}
}
