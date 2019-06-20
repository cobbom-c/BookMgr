package top.ourck.beans;

public class Instruct {

	private int id;
	private Teacher teacher;
	private Lesson lesson;
	
	public Instruct() {
		// TODO Auto-generated constructor stub
	}

	public Instruct(Teacher teacher, Lesson lesson) {
		super();
		this.teacher = teacher;
		this.lesson = lesson;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
