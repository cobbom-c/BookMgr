package top.ourck.dao;

import java.util.List;

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

import top.ourck.beans.Attend;

@Mapper
public interface AttendDAO extends SimpleDAO<Attend> {

	String TABLE_NAME = " " + "attend" + " ";
	String FIELDS = " " + "cid, lid" + " ";
	String SELECT_FIELDS = " " + "id, " + FIELDS + " ";
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + FIELDS + ")" + " VALUES( #{clazz.id}, #{lesson.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "cid = #{clazz.id}, "
			+ "lid = #{lesson.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Attend obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Attend obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "cid", property = "clazz", 
				one = @One(select = "top.ourck.dao.ClassDAO.select")),
		@Result(column = "lid", property = "lesson", 
				one = @One(select = "top.ourck.dao.LessonDAO.select"))
		
	})
	Attend select(int id);
	
	@Select(LIST_SQL)
	@Results({
		@Result(column = "cid", property = "clazz", 
				one = @One(select = "top.ourck.dao.ClassDAO.select")),
		@Result(column = "lid", property = "lesson", 
		one = @One(select = "top.ourck.dao.LessonDAO.select"))
		
	})
	List<Attend> list(@Param("start") int start,
						@Param("offset") int offset);
}
