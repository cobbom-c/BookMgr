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
			+ "num = #{num}, "
			+ "uid = #{student.id} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	String LIST_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "LIMIT #{start}, #{offset}";
	String SELECT_BY_UID_LID_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE uid = #{uid} AND bid = #{bid}";
	// 这句SQL单独修改！
	String GROUP_BY_BID_SQL = "SELECT bid, SUM(num) AS num FROM" + TABLE_NAME + "GROUP BY bid LIMIT #{start}, #{offset}";
	
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
				one = @One(select = "top.ourck.dao.BookDAO.select")),
		@Result(column = "uid", property = "student",
				one = @One(select = "top.ourck.dao.StudentDAO.select"))
	})
	BookOrder select(int id);

	@Select(SELECT_BY_UID_LID_SQL)
	@Results({
			@Result(column = "bid", property = "book",
					one = @One(select = "top.ourck.dao.BookDAO.select")),
			@Result(column = "uid", property = "student",
					one = @One(select = "top.ourck.dao.StudentDAO.select"))
	})
	BookOrder selectByUidBid(@Param("uid")int uid ,
								@Param("bid")int bid);
	
	@Select(LIST_SQL)
	@Results({
		@Result(column = "bid", property = "book",
				one = @One(select = "top.ourck.dao.BookDAO.select")),
		@Result(column = "uid", property = "student",
				one = @One(select = "top.ourck.dao.StudentDAO.select"))
	})
	List<BookOrder> list(@Param("start") int start,
						@Param("offset") int offset);
	
	@Select(GROUP_BY_BID_SQL)
	@Results({
		@Result(column = "bid", property = "book",
				one = @One(select = "top.ourck.dao.BookDAO.select")),
		@Result(column = "num", property = "num")
	})
	List<BookOrder> listGroupByBid(@Param("start") int start,
									@Param("offset") int offset);
}
