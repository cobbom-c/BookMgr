package top.ourck.beans;

public class LessonDetail {

	private int id;
	private String lessonCode;
	private String type;
	private String education;
	private String pos;
	private String language;
	private int maxStunum;
	private int stunum;
	private int beginWeek;
	private int endWeek;
	private int totalWeek;
	private int hoursWeekly;
	private int practiceWeek;
	private int totalHours;
	private int score;
	private int semaster;
	
	public LessonDetail() {
		// TODO Auto-generated constructor stub
	}

	public LessonDetail(int id, String lessonCode, String type, String education, String pos, String language,
			int maxStunum, int stunum, int beginWeek, int endWeek, int totalWeek, int hoursWeekly, int practiceWeek,
			int totalHours, int score, int semaster) {
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

	public int getId() {
		return id;
	}

	public String getLessonCode() {
		return lessonCode;
	}

	public String getType() {
		return type;
	}

	public String getEducation() {
		return education;
	}

	public String getPos() {
		return pos;
	}

	public String getLanguage() {
		return language;
	}

	public int getMaxStunum() {
		return maxStunum;
	}

	public int getStunum() {
		return stunum;
	}

	public int getBeginWeek() {
		return beginWeek;
	}

	public int getEndWeek() {
		return endWeek;
	}

	public int getTotalWeek() {
		return totalWeek;
	}

	public int getHoursWeekly() {
		return hoursWeekly;
	}

	public int getPracticeWeek() {
		return practiceWeek;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public int getScore() {
		return score;
	}

	public int getSemaster() {
		return semaster;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setMaxStunum(int maxStunum) {
		this.maxStunum = maxStunum;
	}

	public void setStunum(int stunum) {
		this.stunum = stunum;
	}

	public void setBeginWeek(int beginWeek) {
		this.beginWeek = beginWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}

	public void setTotalWeek(int totalWeek) {
		this.totalWeek = totalWeek;
	}

	public void setHoursWeekly(int hoursWeekly) {
		this.hoursWeekly = hoursWeekly;
	}

	public void setPracticeWeek(int practiceWeek) {
		this.practiceWeek = practiceWeek;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setSemaster(int semaster) {
		this.semaster = semaster;
	}
	
	
}
