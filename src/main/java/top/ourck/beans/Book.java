package top.ourck.beans;

public class Book {

	private int id;
	private BookDetail bookDetail;
	private String status;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, BookDetail bookDetail, String status) {
		super();
		this.id = id;
		this.bookDetail = bookDetail;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}