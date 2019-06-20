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

import top.ourck.beans.Class;

@Mapper
public interface ClassDAO extends SimpleDAO<Class> {

	String TABLE_NAME = " class ";
	String UPDATE_FIELDS = " name, grade, mid ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{name}, #{grade}, #{major.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "name = #{name}, "
			+ "grade = #{grade}, "
			+ "mid = #{major.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Class obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Class obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "mid", property = "major",
				one = @One(select = "top.ourck.dao.MajorDAO.select"))
	})
	Class select(int id);
	
	@Select(LIST_SQL)
	@Results({
		@Result(column = "mid", property = "major",
				one = @One(select = "top.ourck.dao.MajorDAO.select"))
	})
	List<Class> list(@Param("start") int start,
						@Param("offset") int offset);
}
