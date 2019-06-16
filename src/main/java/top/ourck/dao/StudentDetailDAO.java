package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.StudentDetail;

@Mapper
public interface StudentDetailDAO extends SimpleDAO<StudentDetail> {

	String TABLE_NAME = " " + "student_detail" + " ";
	String UPDATE_FIELDS = " " + "name, hometown, cid" + " ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{name}, #{hometown}, #{clazz.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "name = #{name}, "
			+ "hometown = #{hometown}, "
			+ "cid = #{clazz.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(StudentDetail obj);
	
	@Delete(DELETE_SQL)
	@Results({
		@Result(column = "cid", property = "clazz",
				one = @One(select = "top.ourck.dao.ClassDAO.select"))		
	})
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(StudentDetail obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "cid", property = "clazz",
				one = @One(select = "top.ourck.dao.ClassDAO.select"))		
	})
	StudentDetail select(int id);
}
