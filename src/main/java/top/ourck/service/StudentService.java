package top.ourck.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Student;
import top.ourck.beans.StudentDetail;
import top.ourck.beans.UserType;
import top.ourck.dao.StudentDAO;
import top.ourck.dao.StudentDetailDAO;
import top.ourck.dao.StudentTicketDAO;


@Service
public class StudentService implements LoginCharacterService<Student> {

	@Autowired
	private StudentTicketDAO stDao;
	
	@Autowired
	private StudentDAO sDao;
	
	@Autowired
	private StudentDetailDAO sdDao;
	
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
	public void logout(String ticket) {
		stDao.setStatus(ticket, 1);
	}
	
	public List<Student> list() {
		return sDao.list(0, 1000);
	}
	
	// Student & StudentDetail CRUD
	
	@Override
	public Student getById(int id) {
		return sDao.select(id);
	}
	
	public void addStudent(Student student) {
		addStudentDetail(student.getStudentDetail());
		sDao.add(student);
	}
	
	/**
	 * <b>为什么要把这一方法独立出来？</b>
	 * 因为存在暂未录入StudentDetail的Student。此时他的detail_id是null，<br>
	 * 而在系统内部的处理中用student.studentDetail.id = -1来表示这种情况。<br>
	 * 在这种情形下，就必须先新增一条StudentDetail的记录。<br>
	 * 也就因此这个方法不能像其他的CRUD那样与Student一起执行。
	 * @param td
	 */
	public void addStudentDetail(StudentDetail td) {
		sdDao.add(td);
	}
	
	public void updateStudent(Student student) {
		sdDao.update(student.getStudentDetail());
		sDao.update(student);
	}
	
	public void deleteStudent(int tid) {
		Student t = getById(tid);
		StudentDetail td = t.getStudentDetail();
		sDao.delete(t.getId());
		sdDao.delete(td.getId());
	}
}
