package top.ourck.beans;

public class UseBook {

	private Lesson lesson;
	private Book book;
	
	public UseBook() {
		// TODO Auto-generated constructor stub
	}

	public UseBook(Lesson lesson, Book book) {
		super();
		this.lesson = lesson;
		this.book = book;
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
