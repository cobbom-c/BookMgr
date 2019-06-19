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

import top.ourck.beans.Student;

@Mapper
public interface StudentDAO extends SimpleDAO<Student>{

	String TABLE_NAME = " student ";
	String UPDATE_FIELDS = " username, password, detail_id ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;

	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{userName}, #{password}, #{studentDetail.id} )";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "username = #{userName}, "
			+ "password = #{password}, "
			+ "detail_id = #{studentDetail.id} "
			+ "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_BY_NAME_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE username = #{userName}";
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";

	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Student obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "detail_id", property = "studentDetail",
				one = @One(select = "top.ourck.dao.StudentDetailDAO.select"))		
	})
	Student select(int id);
	
	@Update(UPDATE_SQL)
	void update(Student obj);

	@Select(SELECT_BY_NAME_SQL)
	@Results({
		@Result(column = "detail_id", property = "studentDetail",
				one = @One(select = "top.ourck.dao.StudentDetailDAO.select"))		
	})
	Student selectByUserName(String userName);
	
	@Select(LIST_SQL)
	List<Student> list(@Param("start") int start,
						@Param("offset") int offset);
	
}
