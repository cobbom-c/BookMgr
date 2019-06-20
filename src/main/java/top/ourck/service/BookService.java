package top.ourck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Book;
import top.ourck.beans.BookDetail;
import top.ourck.dao.BookDAO;
import top.ourck.dao.BookDetailDAO;

@Service
public class BookService {

	@Autowired
	private BookDAO bDao;
	
	@Autowired
	private BookDetailDAO bdDao;
	
	public List<Book> list() {
		return bDao.list(0, 1000);
	}
	
	// Book & BookDetail CRUD
	
	public Book getById(int id) {
		return bDao.select(id);
	}
	
	public void addBook(Book book) {
		addBookDetail(book.getBookDetail());
		bDao.add(book);
	}
	
	/**
	 * <b>为什么要把这一方法独立出来？</b>
	 * 因为存在暂未录入BookDetail的Book。此时他的detail_id是null，<br>
	 * 而在系统内部的处理中用book.bookDetail.id = -1来表示这种情况。<br>
	 * 在这种情形下，就必须先新增一条BookDetail的记录。<br>
	 * 也就因此这个方法不能像其他的CRUD那样与Book一起执行。
	 * @param td
	 */
	public void addBookDetail(BookDetail td) {
		bdDao.add(td);
	}
	
	public void updateBook(Book book) {
		bdDao.update(book.getBookDetail());
		bDao.update(book);
	}
	
	public void deleteBook(int tid) {
		Book t = getById(tid);
		BookDetail td = t.getBookDetail();
		bDao.delete(t.getId());
		bdDao.delete(td.getId());
	}
}
