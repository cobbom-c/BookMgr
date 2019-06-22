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

import top.ourck.beans.BookOrder;

@Mapper
public interface BookOrderDAO extends SimpleDAO<BookOrder> {

	// TODO 改前六行 & 泛型关键字！
	String TABLE_NAME = " " + "book_order" + " ";
	String UPDATE_FIELDS = " " + "bid, num, uid" + " ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES( #{book.id}, #{num} ,#{student.id})";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "bid = #{book.id}, "
			+ "num = #{num} "
			+ "uid = #{student.id}"
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(BookOrder obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(BookOrder obj);
	
	@Select(SELECT_SQL)
	@Results({
		@Result(column = "bid", property = "book",
				one = @One(select = "top.ourck.dao.BookDAO.select"))
	})
	BookOrder select(int id);

	@Select("SELECT num FROM book_order WHERE uid = #{uid} AND bid = #{bid}")
	@Results({
			@Result(column = "bid", property = "book",
					one = @One(select = "top.ourck.dao.BookDAO.select")),
			@Result(column = "uid", property = "student",
					one = @One(select = "top.ourck.dao.StudentDAO.select"))
	})
	BookOrder select(int uid ,int bid);
}
