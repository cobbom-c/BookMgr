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
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";
	// 这句SQL比较特殊，需要单独修改！
	String SEARCH_SQL = "SELECT" + SELECT_FIELDS
					+ "FROM" + TABLE_NAME + "LEFT JOIN "
							+ "( SELECT lesson_code, id AS did FROM" + LessonDetailDAO.TABLE_NAME + ") dt ON detail_id = dt.did "
					+ "WHERE name LIKE '%${keyword}%' OR lesson_code LIKE '%${keyword}%';"; // P.S.#{}写在字符串中识别不了 需要改称${}
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Lesson obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Lesson obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "detail_id", property = "lessonDetail",
				one = @One(select = "top.ourck.dao.LessonDetailDAO.select"))
	})
	Lesson select(int id);
	
	@Select(LIST_SQL)
	@Results({
		@Result(column = "detail_id", property = "lessonDetail",
				one = @One(select = "top.ourck.dao.LessonDetailDAO.select"))
	})
	List<Lesson> list(@Param("start") int start,
						@Param("offset") int offset);
	
	@Select(SEARCH_SQL)
	@Results({
		@Result(column = "detail_id", property = "lessonDetail",
				one = @One(select = "top.ourck.dao.LessonDetailDAO.select"))
	})
	List<Lesson> search(@Param("keyword") String keyword);
}
