package top.ourck.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.AdminTicket;
import top.ourck.beans.StudentTicket;
import top.ourck.beans.TeacherTicket;
import top.ourck.beans.UserType;
import top.ourck.beans.util.LoginTicket;
import top.ourck.beans.util.User;
import top.ourck.dao.AdminDAO;
import top.ourck.dao.AdminTicketDAO;
import top.ourck.dao.StudentDAO;
import top.ourck.dao.StudentTicketDAO;
import top.ourck.dao.TeacherDAO;
import top.ourck.dao.TeacherTicketDAO;

@Service
public class LoginTicketService {

	private static final int EXPIRE_SEC = 60 * 5; // 5-min man
	
	@Autowired
	private TeacherTicketDAO ttDao;
	
	@Autowired
	private TeacherDAO tDao;
	
	@Autowired
	private StudentTicketDAO stDao;
	
	@Autowired
	private StudentDAO sDao;
	
	@Autowired
	private AdminTicketDAO atDao;
	
	@Autowired
	private AdminDAO aDao;
	
	public User validateTicket(UserType type, String ticket) {
		switch(type) {
		case ADMIN: return validateAdminTicket(ticket);
		case STUDENT: return validateStudentTicket(ticket);
		case TEACHER: return validateTeacherTicket(ticket);
		default:
			return null;
		}
	}
	
	public LoginTicket getLoginTicket(UserType type, String ticket) {
		switch(type) {
		case ADMIN: return LoginTicket.wrap(getAdminTicket(ticket));
		case STUDENT: return LoginTicket.wrap(getStudentTicket(ticket));
		case TEACHER: return LoginTicket.wrap(getTeacherTicket(ticket));
		default:
			return null;
		}
	}
	
	public LoginTicket genLoginTicket(User user) {
		switch(user.getType()) {
		case ADMIN: return LoginTicket.wrap(genAdminTicket(user.getId(), EXPIRE_SEC));
		case STUDENT: return LoginTicket.wrap(genStudentTicket(user.getId(), EXPIRE_SEC));
		case TEACHER: return LoginTicket.wrap(genTeacherTicket(user.getId(), EXPIRE_SEC));
		default:
			return null;
		}
	}
	
	private User validateTeacherTicket(String ticket) {
		// 1. Get ticket string.
		TeacherTicket t = getTeacherTicket(ticket);
		if(t == null) return null;
		
		// 2. Validate this ticket.
		Date deadline = t.getExpired();
		Date now = new Date();
		if(deadline.compareTo(now) < 0 || t.getStatus() != 0) {
			// If this ticket has expired.
			// TODO Delete this ticket.
			return null;
		}
		
		// 3. Return user bean.
		User u = User.wrap(t.getTeacher());
		return u;
	}
	
	private TeacherTicket getTeacherTicket(String ticket) {
		TeacherTicket t = ttDao.selectByTicket(ticket);
		return t;
	}
	
	private User validateStudentTicket(String ticket) {
		// 1. Get ticket string.
		StudentTicket t = getStudentTicket(ticket);
		if(t == null) return null;
		
		// 2. Validate this ticket.
		Date deadline = t.getExpired();
		Date now = new Date();
		if(deadline.compareTo(now) < 0 || t.getStatus() != 0) {
			// If this ticket has expired.
			// TODO Delete this ticket.
			return null;
		}
		
		// 3. Return user bean.
		User u = User.wrap(t.getStudent());
		return u;
	}
	
	private StudentTicket getStudentTicket(String ticket) {
		StudentTicket t = stDao.selectByTicket(ticket);
		return t;
	}
	
	private User validateAdminTicket(String ticket) {
		// 1. Get ticket string.
		AdminTicket t = getAdminTicket(ticket);
		if(t == null) return null;
		
		// 2. Validate this ticket.
		Date deadline = t.getExpired();
		Date now = new Date();
		if(deadline.compareTo(now) < 0 || t.getStatus() != 0) {
			// If this ticket has expired.
			// TODO Delete this ticket.
			return null;
		}
		
		// 3. Return user bean.
		User u = User.wrap(t.getAdmin());
		return u;
	}
	
	private AdminTicket getAdminTicket(String ticket) {
		AdminTicket t = atDao.selectByTicket(ticket);
		return t;
	}

	private TeacherTicket genTeacherTicket(int uid, int expireSec) {
		TeacherTicket t = new TeacherTicket();
		Date d = new Date();
		d.setTime(d.getTime() + expireSec * 1000);
		String ticketStr = UUID.randomUUID().toString().replaceAll("-", "");
		
		t.setExpired(d);
		t.setTicket(ticketStr);
		t.setStatus(0);
		t.setTeacher(tDao.select(uid));
		
		ttDao.add(t);
		return t;
	}

	private StudentTicket genStudentTicket(int uid, int expireSec) {
		StudentTicket t = new StudentTicket();
		Date d = new Date();
		d.setTime(d.getTime() + expireSec * 1000);
		String ticketStr = UUID.randomUUID().toString().replaceAll("-", "");
		
		t.setExpired(d);
		t.setTicket(ticketStr);
		t.setStatus(0);
		t.setStudent(sDao.select(uid));
		
		stDao.add(t);
		return t;
	}

	private AdminTicket genAdminTicket(int uid, int expireSec) {
		AdminTicket t = new AdminTicket();
		Date d = new Date();
		d.setTime(d.getTime() + expireSec * 1000);
		String ticketStr = UUID.randomUUID().toString().replaceAll("-", "");
		
		t.setExpired(d);
		t.setTicket(ticketStr);
		t.setStatus(0);
		t.setAdmin(aDao.select(uid));
		
		atDao.add(t);
		return t;
	}
}
