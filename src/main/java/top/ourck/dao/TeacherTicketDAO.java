package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.TeacherTicket;

@Mapper
public interface TeacherTicketDAO extends SimpleDAO<TeacherTicket> {

	// teacher_ticket(id, ticket, uid, expired, status)
	
	String TABLE_NAME = " teacher_ticket ";
	String UPDATE_FIELDS = " ticket, uid, expired, status ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( "
			+ "#{ticket}, "
			+ "#{teacher.id}, "
			+ "#{expired}, "
			+ "#{status}"
			+ ")";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "ticket = #{ticket}, "
			+ "uid = #{teacher.id}, "
			+ "expired = #{expired}, "
			+ "status = #{status} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_BY_TICKET_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE ticket = #{ticket}";
	String UPDATE_SET_STATUS_SQL = "UPDATE" + TABLE_NAME + "SET status = #{status} WHERE ticket = #{ticket}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(TeacherTicket obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(TeacherTicket obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "uid", property = "teacher",
				one = @One(select = "top.ourck.dao.TeacherDAO.select"))
	})
	TeacherTicket select(int id);
	
	@Select(SELECT_BY_TICKET_SQL)
	@Results({
		@Result(column = "uid", property = "teacher",
				one = @One(select = "top.ourck.dao.TeacherDAO.select"))
	})
	TeacherTicket selectByTicket(String ticket);
	
	@Update(UPDATE_SET_STATUS_SQL)
	void setStatus(@Param("ticket") String ticket,
					@Param("status") int status);
}
