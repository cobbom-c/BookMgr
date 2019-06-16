package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.Book;


public interface BookDAO extends SimpleDAO<Book> {

	// TODO 改前六行 & 泛型关键字！
	String TABLE_NAME = " " + "book" + " ";
	String UPDATE_FIELDS = " " + "detail_id, status" + " ";
	String INSERT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{bookDetail.id}, #{status} )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "detail_id = #{bookDetail.id}, "
			+ "status = #{status} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(Book obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(Book obj);
	
	@Select(SELECT_SQL)
	Book select(int id);
}
