package top.ourck.beans;

public class BookOrder {

	private int id;
	private Book book;
	private int num;
	private Student student;

	public BookOrder() {
		// TODO Auto-generated constructor stub
	}

	public BookOrder(int id, Book book, int num) {
		super();
		this.id = id;
		this.book = book;
		this.num = num;
	}

	public BookOrder(int id, Book book, int num, Student student) {
		this.id = id;
		this.book = book;
		this.num = num;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
