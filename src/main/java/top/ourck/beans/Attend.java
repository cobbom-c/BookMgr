package top.ourck.beans;

public class Attend {

	private int id;
	private Class clazz;
	private Lesson lesson;
	
	public Attend() {
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
}
