package app.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import app.dto.AuthorInfo;
import app.dto.BookChart;
import app.dto.BookInfo;
import app.model.Book;

public interface BookService extends BaseService<Integer, Book> {

	List<BookInfo> listBookByPage(Integer page,String typeSort );
	List<BookInfo> listBookByAuthor(Integer page,String typeSort ,String authorName);
	Long count();

	Integer page(Long count, int maxResult);

	List<BookInfo> findBookByTitle(String title);

	List<String> getListTitle();

	BookInfo findBookById(int id);

	List<BookInfo> listBooksByCategoryId(Integer Category_id);

	boolean saveBook(BookInfo bookInfo, MultipartFile image, String path);
	
	List<BookChart> loadBooksByDate(int month, int year);
	
	Set<AuthorInfo> listAuthor();
	
	List<Book> listBooksByAuthorName(String author);
	
	List<Book> listBookByCategoryId(int category_id);
	
	List<BookInfo> listBookByCategory(Integer page,String typeSort ,int  category_id);
	
	List<Book> listBookByPublisherId(int publisher_id);
	
	List<BookInfo> listBookByPublisherPage(Integer page,String typeSort ,int  publisher_id);
	
	List<BookInfo> listBookByAuthorPage(Integer page,String typeSort ,String  author);
	
	
	
}
