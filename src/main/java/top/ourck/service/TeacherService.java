package top.ourck.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Teacher;
import top.ourck.beans.UserType;
import top.ourck.dao.TeacherDAO;
import top.ourck.dao.TeacherTicketDAO;

@Service
public class TeacherService implements LoginCharacterService<Teacher> {

	@Autowired
	private TeacherDAO tDao;
	
	@Autowired
	private TeacherTicketDAO ttDao;
	
	@Override
	public Map<String, Object> getAuth(String userName, String password) {
		Teacher t = tDao.selectByUserName(userName);
		Map<String, Object> info = new HashMap<String, Object>();
		if(t == null) {
			info.put("success", "false");
			info.put("msg", "User name not exists!");
		}
		else if(t.getPassword().equals(password)) {
			info.put("success", "true");
			info.put("uid", "" + t.getId());
			info.put("user", t);
			info.put("type", UserType.TEACHER);
		}
		else {
			info.put("success", "false");
			info.put("msg", "Password invalid!");
		}
		
		return info;
	}

	@Override
	public Map<String, Object> register(Teacher t) {
		Map<String, Object> info = new HashMap<>();
		Teacher old = tDao.selectByUserName(t.getUserName());

		if(old == null) {
			// TODO Validate t.userName & password whether it contains SPCHAR!
			tDao.add(t);
			info.put("success", "true");
			info.put("uid", "" + t.getId());
			info.put("user", t);
			info.put("type", UserType.TEACHER);
		}
		else {
			info.put("success", "false");
			info.put("msg", "There is a user using your userName!");
		}
		
		return info;
	}

	@Override
	public Teacher getById(int id) {
		return tDao.select(id);
	}

	@Override
	public void logout(String ticket) {
		ttDao.setStatus(ticket, 1);
	}
	
}
