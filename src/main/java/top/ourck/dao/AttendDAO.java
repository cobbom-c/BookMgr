package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.Attend;

public interface AttendDAO extends SimpleDAO<Attend> {

	String TABLE_NAME = " " + "attend" + " ";
	String UPDATE_FIELDS = " " + "cid, lid" + " ";
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{class.id}, #{Lesson.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "cld = #{class.id}, "
			+ "lid = #{Lesson.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
//	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Attend obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Attend obj);
	
	@Select(SELECT_SQL)
	Attend select(int id);
}
