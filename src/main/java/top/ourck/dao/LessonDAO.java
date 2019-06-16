package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.Lesson;

@Mapper
public interface LessonDAO extends SimpleDAO<Lesson> {

	String TABLE_NAME = " " + "lesson" + " ";
	String UPDATE_FIELDS = " " + "name, detail_id" + " ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{name}, #{lessonDetail.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "name = #{name}, "
			+ "detail_id = #{lessonDetail.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Lesson obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Lesson obj);
	
	@Select(SELECT_SQL)
	Lesson select(int id);
}
