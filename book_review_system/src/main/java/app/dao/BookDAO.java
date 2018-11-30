package app.dao;

import java.util.List;
import app.model.Book;

public interface BookDAO extends BaseDAO<Integer, Book> {

	List<Book> findAll(Integer page,Integer maxResult);

	Long count();

	Book findByIdLock(int id, boolean lock);

	List<Book> findBooksByTitle(String title);

	List<String> findAllBookTitle();

	List<Book> loadBooks();
	
	List<Book> loadBooksByDateReview(int month, int year);
	
	List<Book> findBooksByKeyWorld(String key);
}
