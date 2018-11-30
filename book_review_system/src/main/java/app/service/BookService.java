package app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import app.dto.BookChart;
import app.dto.BookInfo;
import app.model.Book;

public interface BookService extends BaseService<Integer, Book> {

	List<BookInfo> listBookByPage(Integer page,String typeSort );

	Long count();

	Integer page(Long count, int maxResult);

	List<BookInfo> findBookByTitle(String title);

	List<String> getListTitle();

	BookInfo findBookById(int id);

	List<BookInfo> listBooksByCategoryId(Integer Category_id);

	boolean saveBook(BookInfo bookInfo, MultipartFile image, String path);
	
	List<BookChart> loadBooksByDate(int month, int year);
}
