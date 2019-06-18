package top.ourck.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Admin;
import top.ourck.beans.UserType;
import top.ourck.dao.AdminDAO;
import top.ourck.dao.AdminTicketDAO;


@Service
public class AdminService implements LoginCharacterService<Admin> {

	@Autowired
	private AdminTicketDAO atDao;
	
	@Autowired
	private AdminDAO sDao;
	
	@Override
	public Map<String, Object> getAuth(String userName, String password) {
		Admin t = sDao.selectByUserName(userName);
		Map<String, Object> info = new HashMap<String, Object>();
		if(t == null) {
			info.put("success", "false");
			info.put("msg", "User name not exists!");
		}
		else if(t.getPassword().equals(password)) {
			info.put("success", "true");
			info.put("uid", "" + t.getId());
			info.put("user", t);
			info.put("type", UserType.ADMIN); // 放个class，用反射可以？不好。不信在main试试。
		}
		else {
			info.put("success", "false");
			info.put("msg", "Password invalid!");
		}
		
		return info;
	}

	@Override
	public Map<String, Object> register(Admin t) {
		Map<String, Object> info = new HashMap<>();
		Admin old = sDao.selectByUserName(t.getUserName());

		if(old == null) {
			// TODO Validate t.userName & password whether it contains SPCHAR!
			sDao.add(t);
			info.put("success", "true");
			info.put("uid", "" + t.getId());
			info.put("user", t);
			info.put("type", UserType.ADMIN);
		}
		else {
			info.put("success", "false");
			info.put("msg", "There is a user using your userName!");
		}
		
		return info;
	}

	@Override
	public Admin getById(int id) {
		return sDao.select(id);
	}

	@Override
	public void logout(String ticket) {
		atDao.setStatus(ticket, 1);
	}
}
