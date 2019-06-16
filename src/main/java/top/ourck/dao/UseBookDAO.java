package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.UseBook;

public interface UseBookDAO extends SimpleDAO<UseBook> {

	// TODO 改前六行 & 泛型关键字！
	String TABLE_NAME = " " + "use_book" + " ";
	String FIELDS = " " + "lid, bid" + " ";
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + FIELDS + ")" + " VALUES( #{lesson.id}, #{book.id} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "lid = #{lesson.id}, "
			+ "bid= #{book.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(UseBook obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(UseBook obj);
	
	@Select(SELECT_SQL)
	UseBook select(int id);
}
