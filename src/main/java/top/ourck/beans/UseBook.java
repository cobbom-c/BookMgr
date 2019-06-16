package top.ourck.beans;

public class UseBook {

	private int id;
	private Lesson lesson;
	private Book book;
	
	public UseBook(int id, Lesson lesson, Book book) {
		super();
		this.id = id;
		this.lesson = lesson;
		this.book = book;
	}

	public UseBook() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
