package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.Major;
import top.ourck.beans.TeacherTicket;

@Mapper
public interface TeacherTicketDAO extends SimpleDAO<TeacherTicket> {

	String TABLE_NAME = " teacher_ticket ";
	String UPDATE_FIELDS = " ticket, uid ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{id}, #{ticket}, #{teacher.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "name = #{name} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(TeacherTicket obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(TeacherTicket obj);
	
	@Select(SELECT_SQL)
	TeacherTicket select(int id);
}
