package top.ourck.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Teacher;
import top.ourck.beans.TeacherDetail;
import top.ourck.beans.UserType;
import top.ourck.dao.TeacherDAO;
import top.ourck.dao.TeacherDetailDAO;
import top.ourck.dao.TeacherTicketDAO;

@Service
public class TeacherService implements LoginCharacterService<Teacher> {

	@Autowired
	private TeacherDAO tDao;
	
	@Autowired
	private TeacherTicketDAO ttDao;
	
	@Autowired
	private TeacherDetailDAO tdDao;
	
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
	public void logout(String ticket) {
		ttDao.setStatus(ticket, 1);
	}
	
	public List<Teacher> list() {
		return tDao.list(0, 1000);
	}
	
	// Teacher & TeacherDetail CRUD
	
	@Override
	public Teacher getById(int id) {
		return tDao.select(id);
	}
	
	public void addTeacher(Teacher teacher) {
		addTeacherDetail(teacher.getTeacherDetail());
		tDao.add(teacher);
	}
	
	/**
	 * <b>为什么要把这一方法独立出来？</b>
	 * 因为存在暂未录入TeacherDetail的Teacher。此时他的detail_id是null，<br>
	 * 而在系统内部的处理中用teacher.teacherDetail.id = -1来表示这种情况。<br>
	 * 在这种情形下，就必须先新增一条TeacherDetail的记录。<br>
	 * 也就因此这个方法不能像其他的CRUD那样与Teacher一起执行。
	 * @param td
	 */
	public void addTeacherDetail(TeacherDetail td) {
		tdDao.add(td);
	}
	
	public void updateTeacher(Teacher teacher) {
		tdDao.update(teacher.getTeacherDetail());
		tDao.update(teacher);
	}
	
	public void deleteTeacher(int tid) {
		Teacher t = getById(tid);
		TeacherDetail td = t.getTeacherDetail();
		tDao.delete(t.getId());
		tdDao.delete(td.getId());
	}
}
