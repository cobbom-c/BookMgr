package top.ourck.beans;

public class UseBook {

	private Integer id;
	private Lesson lesson;
	private Book book;
	
	public UseBook() {
		// TODO Auto-generated constructor stub
	}

	public UseBook(Integer id, Lesson lesson, Book book) {
		super();
		this.id = id;
		this.lesson = lesson;
		this.book = book;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
