package app.dao;
import java.util.List;
import app.model.Book;

public interface BookDAO extends BaseDAO<Integer, Book> {

	List<Book> findAll(Integer page,Integer maxResult);

	Long count();
	
	List<Book> booksByAuthor(Integer page,Integer maxResult,String authorName);

	Book findByIdLock(int id, boolean lock);

	List<Book> findBooksByTitle(String title);

	List<String> findAllBookTitle();
	
	List<String> ListAuthor();

	List<Book> loadBooks();
	
	List<Book> loadBooksByDateReview(int month, int year);
	
	List<Book> findBooksByKeyWorld(String key);
	
	List<Book> findBookByKeyWorldLike(String key);
	
	List<Book> findBooksByAuthor(String author);
	
	List<Book> findBooksByCategoryId(int category_id);
	
	List<Book> findBookByCategoryPage(Integer page,Integer maxResult,int category_id);
	
	List<Book> findBooksByPublisherId(int publisher_id);
	
	List<Book> findBookByPublisherPage(Integer page,Integer maxResult,int publisher_id);
	
	List<Book> findBookByTitlePage(Integer page,Integer maxResult,String author);
	
	
}
