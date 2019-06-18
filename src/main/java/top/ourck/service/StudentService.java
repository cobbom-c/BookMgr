package top.ourck.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Student;
import top.ourck.beans.StudentTicket;
import top.ourck.beans.UserType;
import top.ourck.dao.StudentDAO;
import top.ourck.dao.StudentTicketDAO;


@Service
public class StudentService implements LoginCharacterService<Student> {

	@Autowired
	private StudentTicketDAO stDao;
	
	@Autowired
	private StudentDAO sDao;
	
	@Override
	public Map<String, Object> getAuth(String userName, String password) {
		Student t = sDao.selectByUserName(userName);
		Map<String, Object> info = new HashMap<String, Object>();
		if(t == null) {
			info.put("success", "false");
			info.put("msg", "User name not exists!");
		}
		else if(t.getPassword().equals(password)) {
			info.put("success", "true");
			info.put("user", t);
			info.put("type", UserType.STUDENT);
		}
		else {
			info.put("success", "false");
			info.put("msg", "Password invalid!");
		}
		
		return info;
	}

	@Override
	public Map<String, Object> register(Student t) {
		Map<String, Object> info = new HashMap<>();
		Student old = sDao.selectByUserName(t.getUserName());

		if(old == null) {
			// TODO Validate t.userName & password whether it contains SPCHAR!
			sDao.add(t);
			info.put("success", "true");
			info.put("uid", "" + t.getId());
		}
		else {
			info.put("success", "false");
			info.put("msg", "There is a user using your userName!");
			info.put("user", t);
			info.put("type", UserType.STUDENT);
		}
		
		return info;
	}

	@Override
	public Student getById(int id) {
		return sDao.select(id);
	}
	
	@Override
	public void logout(String ticket) {
		stDao.setStatus(ticket, 1);
	}
}
