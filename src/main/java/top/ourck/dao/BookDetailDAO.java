package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.BookDetail;

public interface BookDetailDAO extends SimpleDAO<BookDetail> {

	// TODO 改前六行 & 泛型关键字！
	String TABLE_NAME = " " + "book_detail" + " ";
	String UPDATE_FIELDS = " " + "name, ISBN, edition, chief_editor, institute, pub_date, author, price" + " ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( "
			+ "#{name}, #{ISBN}, #{edition}, #{chiefEditor}, #{institute}, #{pubDate}, #{author}, #{price}"
			+ " )";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "name = #{name}, "
			+ "ISBN = #{ISBN}, "
			+ "edition = #{edition}, "
			+ "chief_editor = #{chiefEditor}, "
			+ "institute = #{institute}, "
			+ "pub_date = #{pubDate}, "
			+ "author = #{author}, "
			+ "price = #{price} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(BookDetail obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(BookDetail obj);
	
	@Select(SELECT_SQL)
	BookDetail select(int id);
}
