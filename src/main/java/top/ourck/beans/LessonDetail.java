package top.ourck.beans;

public class LessonDetail {

	private Integer id;
	private String lessonCode;
	private String type;
	private String education;
	private String pos;
	private String language;
	private Integer maxStunum;
	private Integer stunum;
	private Integer beginWeek;
	private Integer endWeek;
	private Integer totalWeek;
	private Integer hoursWeekly;
	private Integer practiceWeek;
	private Integer totalHours;
	private Integer score;
	private Integer semaster;
	
	public LessonDetail() {
		// TODO Auto-generated constructor stub
	}

	public LessonDetail(Integer id, String lessonCode, String type, String education, String pos, String language,
			Integer maxStunum, Integer stunum, Integer beginWeek, Integer endWeek, Integer totalWeek,
			Integer hoursWeekly, Integer practiceWeek, Integer totalHours, Integer score, Integer semaster) {
		super();
		this.id = id;
		this.lessonCode = lessonCode;
		this.type = type;
		this.education = education;
		this.pos = pos;
		this.language = language;
		this.maxStunum = maxStunum;
		this.stunum = stunum;
		this.beginWeek = beginWeek;
		this.endWeek = endWeek;
		this.totalWeek = totalWeek;
		this.hoursWeekly = hoursWeekly;
		this.practiceWeek = practiceWeek;
		this.totalHours = totalHours;
		this.score = score;
		this.semaster = semaster;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLessonCode() {
		return lessonCode;
	}

	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getMaxStunum() {
		return maxStunum;
	}

	public void setMaxStunum(Integer maxStunum) {
		this.maxStunum = maxStunum;
	}

	public Integer getStunum() {
		return stunum;
	}

	public void setStunum(Integer stunum) {
		this.stunum = stunum;
	}

	public Integer getBeginWeek() {
		return beginWeek;
	}

	public void setBeginWeek(Integer beginWeek) {
		this.beginWeek = beginWeek;
	}

	public Integer getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}

	public Integer getTotalWeek() {
		return totalWeek;
	}

	public void setTotalWeek(Integer totalWeek) {
		this.totalWeek = totalWeek;
	}

	public Integer getHoursWeekly() {
		return hoursWeekly;
	}

	public void setHoursWeekly(Integer hoursWeekly) {
		this.hoursWeekly = hoursWeekly;
	}

	public Integer getPracticeWeek() {
		return practiceWeek;
	}

	public void setPracticeWeek(Integer practiceWeek) {
		this.practiceWeek = practiceWeek;
	}

	public Integer getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getSemaster() {
		return semaster;
	}

	public void setSemaster(Integer semaster) {
		this.semaster = semaster;
	}
	
	
}
