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

import top.ourck.beans.UseBook;

@Mapper
public interface UseBookDAO extends SimpleDAO<UseBook> {

	String TABLE_NAME = " " + "use_book" + " ";
	String FIELDS = " " + "lid, bid" + " ";
	String SELECT_FIELDS = " " + "id, " + FIELDS + " ";
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + FIELDS + ")" + " VALUES( #{lesson.id}, #{book.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "lid = #{lesson.id}, "
			+ "bid= #{book.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(UseBook obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(UseBook obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "bid", property = "book",
				one = @One(select = "top.ourck.dao.BookDAO.select")),
		@Result(column = "lid", property = "lesson",
				one = @One(select = "top.ourck.dao.LessonDAO.select"))
	})
	UseBook select(int id);
	
	@Select(LIST_SQL)
	@Results({
		@Result(column = "bid", property = "book",
				one = @One(select = "top.ourck.dao.BookDAO.select")),
		@Result(column = "lid", property = "lesson",
				one = @One(select = "top.ourck.dao.LessonDAO.select"))
	})
	List<UseBook> list(@Param("start") int start,
						@Param("offset") int offset);
}
