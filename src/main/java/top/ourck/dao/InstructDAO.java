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

import top.ourck.beans.Instruct;

@Mapper
public interface InstructDAO extends SimpleDAO<Instruct> {

	String TABLE_NAME = " " + "instruct" + " ";
	String FIELDS = " " + "tid, lid" + " ";
	String SELECT_FIELDS = " " + "id," + FIELDS + " ";
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + FIELDS + ")" + " VALUES( #{teacher.id}, #{lesson.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "tid = #{teacher.id}, "
			+ "lid = #{lesson.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";
	String LIST_BY_TID_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME
			+ "WHERE tid = #{tid} "
			+ "LIMIT #{start}, #{offset}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int add(Instruct obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Instruct obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "tid", property = "teacher",
				one = @One(select = "top.ourck.dao.TeacherDAO.select")),
		@Result(column = "lid", property = "lesson",
				one = @One(select = "top.ourck.dao.LessonDAO.select"))
	})
	Instruct select(int id);
	
	@Select(LIST_SQL)
	@Results({
		@Result(column = "tid", property = "teacher",
				one = @One(select = "top.ourck.dao.TeacherDAO.select")),
		@Result(column = "lid", property = "lesson",
				one = @One(select = "top.ourck.dao.LessonDAO.select"))
	})
	List<Instruct> list(@Param("start") int start,
						@Param("offset") int offset);
	
	@Select(LIST_BY_TID_SQL)
	@Results({
		@Result(column = "tid", property = "teacher",
				one = @One(select = "top.ourck.dao.TeacherDAO.select")),
		@Result(column = "lid", property = "lesson",
		one = @One(select = "top.ourck.dao.LessonDAO.select"))
	})
	List<Instruct> listByTid(@Param("tid") int tid,
							@Param("start") int start,
							@Param("offset") int offset);
}
