package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.StudentTicket;

@Mapper
public interface StudentTicketDAO extends SimpleDAO<StudentTicket> {

	// student_ticket(id, ticket, uid, expired, status)
	
	String TABLE_NAME = " student_ticket ";
	String UPDATE_FIELDS = " ticket, uid, expired, status ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( "
			+ "#{ticket}, "
			+ "#{student.id}, "
			+ "#{expired}, "
			+ "#{status}"
			+ ")";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "ticket = #{ticket}, "
			+ "uid = #{student.id}, "
			+ "expired = #{expired}, "
			+ "status = #{status} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_BY_TICKET_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE ticket = #{ticket}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(StudentTicket obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(StudentTicket obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "uid", property = "student",
				one = @One(select = "top.ourck.dao.studentDAO.select"))
	})
	StudentTicket select(int id);
	
	@Select(SELECT_BY_TICKET_SQL)
	@Results({
		@Result(column = "uid", property = "student",
				one = @One(select = "top.ourck.dao.StudentDAO.select"))
	})
	StudentTicket selectByTicket(String ticket);
	
}
