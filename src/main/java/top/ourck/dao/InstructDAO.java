package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.Instruct;

public interface InstructDAO extends SimpleDAO<Instruct> {

	// TODO 改前六行 & 泛型关键字！
	String TABLE_NAME = " " + "instruct" + " ";
	String FIELDS = " " + "tid, lid" + " ";
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + FIELDS + ")" + " VALUES( #{teacher.id}, #{lesson.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "tid = #{teacher.id}, "
			+ "lid = #{lesson.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	int add(Instruct obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Instruct obj);
	
	@Select(SELECT_SQL)
	Instruct select(int id);
}
