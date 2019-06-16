package top.ourck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.ourck.beans.LessonDetail;

public interface LessonDetailDAO extends SimpleDAO<LessonDetail> {

	// TODO 改前六行 & 泛型关键字！
	String TABLE_NAME = " " + "lesson_detail" + " ";
	String UPDATE_FIELDS = " "
			+ "lesson_code, "
			+ "type, "
			+ "education, "
			+ "pos, "
			+ "language, "
			+ "max_stunum, "
			+ "stunum, "
			+ "begin_week, "
			+ "end_week, "
			+ "total_week, "
			+ "hours_weekly, "
			+ "practice_week, "
			+ "total_hours, "
			+ "score, "
			+ "semaster"
			+ " ";
	String SELECT_FIELDS = " id," + UPDATE_FIELDS;
	
	String ADD_SQL = "INSERT INTO" + TABLE_NAME + "(" + UPDATE_FIELDS + ")" + " VALUES("
			+ "#{lessonCode}, "
			+ "#{type}, "
			+ "#{education}, "
			+ "#{pos}, "
			+ "#{language}, "
			+ "#{maxStunum}, "
			+ "#{stunum}, "
			+ "#{beginWeek}, "
			+ "#{endWeek}, "
			+ "#{totalWeek}, "
			+ "#{hoursWeekly}, "
			+ "#{practiceWeek}, "
			+ "#{totalHours}, "
			+ "#{score}, "
			+ "#{semaster}"
			+ ")";
	String UPDATE_SQL = "UPDATE" + TABLE_NAME + "SET "
			+ "lesson_code=#{lessonCode}, "
			+ "type=#{type}, "
			+ "education=#{education}, "
			+ "pos=#{pos}, "
			+ "language=#{language}, "
			+ "max_stunum=#{maxStunum}, "
			+ "stunum=#{stunum}, "
			+ "begin_week=#{beginWeek}, "
			+ "end_week=#{endWeek}, "
			+ "total_week=#{totalWeek}, "
			+ "hours_weekly=#{hoursWeekly}, "
			+ "practice_week=#{practiceWeek}, "
			+ "total_hours=#{totalHours}, "
			+ "score=#{score}, "
			+ "semaster=#{semaster} "
			+ "WHERE id = #{id}";
	String DELETE_SQL = "DELETE FROM" + TABLE_NAME + "WHERE id = #{id}";
	String SELECT_SQL = "SELECT" + SELECT_FIELDS + "FROM" + TABLE_NAME + "WHERE id = #{id}";
	
	@Insert(ADD_SQL)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int add(LessonDetail obj);
	
	@Delete(DELETE_SQL)
	void delete(int id);
	
	@Update(UPDATE_SQL)
	void update(LessonDetail obj);
	
	@Select(SELECT_SQL)
	LessonDetail select(int id);
}
