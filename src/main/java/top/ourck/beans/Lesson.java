package top.ourck.beans;

public class Lesson {

	private int id;
	private String name;
	private LessonDetail lessonDetail;
	
	public Lesson() {
		// TODO Auto-generated constructor stub
	}

	public Lesson(int id, String name, LessonDetail lessonDetail) {
		super();
		this.id = id;
		this.name = name;
		this.lessonDetail = lessonDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LessonDetail getLessonDetail() {
		return lessonDetail;
	}

	public void setLessonDetail(LessonDetail lessonDetail) {
		this.lessonDetail = lessonDetail;
	}

}
