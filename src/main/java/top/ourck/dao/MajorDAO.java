package top.ourck.dao;

import org.apache.ibatis.annotations.*;
import top.ourck.beans.Major;

import java.util.List;

@Mapper
public interface MajorDAO extends SimpleDAO<Major> {

	String TABLE_NAME = " major ";
	String UPDATE_FIELDS = " name, college ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{name}, #{college} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "name = #{name} "
			+ "college = #{college}"
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Major obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Major obj);
	
	@Select(SELECT_SQL)
	Major select(int id);
	
	@Select(LIST_SQL)
	List<Major> list(@Param("start") int start,
						@Param("offset") int offset);
}
