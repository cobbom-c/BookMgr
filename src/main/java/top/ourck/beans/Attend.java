package top.ourck.beans;

public class Attend {

	private Class clazz;
	private Lesson lesson;
	
	public Attend() {
		// TODO Auto-generated constructor stub
	}

	public Attend(Class clazz, Lesson lesson) {
		super();
		this.clazz = clazz;
		this.lesson = lesson;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	
	
}
