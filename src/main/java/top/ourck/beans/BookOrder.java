package top.ourck.beans;

public class BookOrder {

	private int id;
	private Book book;
	private int num;
	
	public BookOrder() {
		// TODO Auto-generated constructor stub
	}

	public BookOrder(int id, Book book, int num) {
		super();
		this.id = id;
		this.book = book;
		this.num = num;
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
	
}
