package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import app.dto.AuthorInfo;
import app.dto.BookChart;
import app.dto.BookInfo;
import app.model.Book;
import app.model.Category;
import app.model.Review;
import app.service.BookService;
import app.util.DriveQuickstart;
import app.util.SortBooks;

public class BookServiceImpl extends BaseServiceImpl implements BookService {
	private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

	@Override
	public Book saveOrUpdate(Book entity) {
		try {
			return bookDAO.saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public boolean delete(Book entity) {
		try {
			delete(entity);
			return true;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public Long count() {
		try {
			return bookDAO.count();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Integer page(Long count, int maxResult) {
		try {
			return (int) ((count < maxResult) ? 1
					: ((count % maxResult == 0) ? (count / maxResult) : (count / maxResult + 1)));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Book findById(Serializable key, boolean lock) {
		try {
			return bookDAO.findById(key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<BookInfo> listBookByPage(Integer page, String typeSort) {
		try {
			if (typeSort == null) {
				return ConvertModelToBean.mapBooksToBooksInf(bookDAO.findAll(page, 8));
			} else {
				if (typeSort.equals("1"))
					return SortBooks.sortBooksByTitle(ConvertModelToBean.mapBooksToBooksInf(bookDAO.findAll(page, 8)));
				return SortBooks
						.sortBooksByPublishDate(ConvertModelToBean.mapBooksToBooksInf(bookDAO.findAll(page, 8)));
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<BookInfo> findBookByTitle(String title) {
		try {
			return ConvertModelToBean.mapBooksToBooksInf(bookDAO.findBooksByTitle(title));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<String> getListTitle() {
		try {
			return bookDAO.findAllBookTitle();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public BookInfo findBookById(int id) {
		try {
			Book book = bookDAO.findById(id);
			List<Review> reviews = reviewDAO.loadReviewsForBook(id);
			BookInfo bookInfo = new BookInfo(book.getId(), book.getTittle(), book.getPublishDate(),
					book.getAuthorName(), book.getNumberOfPage(), book.getImage(), book.getCategory(),
					book.getImageDetail(), book.getPublisher(), book.getDescription());
			bookInfo.setAvgStar(reviews);
			bookInfo.setQuantityVote(reviews);
			bookInfo.setReviews(reviews);
			bookInfo.setPercentStar(reviews);
			return bookInfo;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<BookInfo> listBooksByCategoryId(Integer Category_id) {
		try {
			List<Book> books = bookDAO.loadBooks();
			List<Book> booksTemp = new ArrayList<>();
			for (Book book : books) {
				if (book.getCategory().getId().equals(Category_id)) {
					booksTemp.add(book);
				}
			}
			return ConvertModelToBean.mapBooksToBooksInf(booksTemp);
		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	@Override
	public boolean saveBook(BookInfo bookInfo, MultipartFile image, String path) {
		try {
			if (image != null) {
				bookInfo.setImage(DriveQuickstart.saveToCloud(image));
			}
			Category category = categoryDAO.findById(bookInfo.getCategory().getId());
			Book book = new Book(bookInfo.getTittle(), bookInfo.getPublishDate(), bookInfo.getAuthorName(),
					bookInfo.getNumberOfPage(), bookInfo.getImage(), category);
			saveOrUpdate(book);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Override
	public List<BookChart> loadBooksByDate(int month, int year) {
		try {
			List<BookChart> charts = new ArrayList<>();
			List<Book> books = bookDAO.loadBooksByDateReview(month, year);
			for (Book book : books) {
				BookChart chart = new BookChart();
				chart.setName(book.getTittle());
				chart.setFirstdata(book.getReviews().size());
				charts.add(chart);
			}
			return charts;
		} catch (Exception e) {
			logger.error(e);
			return Collections.emptyList();
		}
	}

	@Override
	public Set<AuthorInfo> listAuthor() {
		try {

			Set<AuthorInfo> setAuthor = new HashSet<>();

			List<String> list = bookDAO.ListAuthor();
			for (String author : list) {
				AuthorInfo authorInfo = new AuthorInfo();
				authorInfo.setName(author);
				authorInfo.setNumberBook(bookDAO.findBooksByAuthor(author).size());
				setAuthor.add(authorInfo);
			}
			return setAuthor;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<BookInfo> listBookByAuthor(Integer page, String typeSort, String authorName) {
		try {
			if (typeSort == null) {
				return ConvertModelToBean.mapBooksToBooksInf(bookDAO.booksByAuthor(page, 8, authorName));
			} else {
				if (typeSort.equals("1"))
					return SortBooks.sortBooksByTitle(
							ConvertModelToBean.mapBooksToBooksInf(bookDAO.booksByAuthor(page, 8, authorName)));
				return SortBooks.sortBooksByPublishDate(
						ConvertModelToBean.mapBooksToBooksInf(bookDAO.booksByAuthor(page, 8, authorName)));
			}
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Book> listBooksByAuthorName(String author) {
		try {
			return bookDAO.findBooksByAuthor(author);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Book> listBookByCategoryId(int category_id) {
		try {
			return bookDAO.findBooksByCategoryId(category_id);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<BookInfo> listBookByCategory(Integer page, String typeSort, int category_id) {
		try {
			if (typeSort == null) {
				return ConvertModelToBean.mapBooksToBooksInf(bookDAO.findBookByCategoryPage(page, 4, category_id));
			} else {
				if (typeSort.equals("1"))
					return SortBooks.sortBooksByTitle(ConvertModelToBean
							.mapBooksToBooksInf(bookDAO.findBookByCategoryPage(page, 4, category_id)));
				return SortBooks.sortBooksByPublishDate(
						ConvertModelToBean.mapBooksToBooksInf(bookDAO.findBookByCategoryPage(page, 4, category_id)));
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Book> listBookByPublisherId(int publisher_id) {
		try {
			return bookDAO.findBooksByPublisherId(publisher_id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<BookInfo> listBookByPublisherPage(Integer page, String typeSort, int publisher_id) {
		try {
			if (typeSort == null) {
				return ConvertModelToBean.mapBooksToBooksInf(bookDAO.findBookByPublisherPage(page, 8, publisher_id));
			} else {
				if (typeSort.equals("1"))
					return SortBooks.sortBooksByTitle(ConvertModelToBean
							.mapBooksToBooksInf(bookDAO.findBookByPublisherPage(page, 8, publisher_id)));
				return SortBooks.sortBooksByPublishDate(
						ConvertModelToBean.mapBooksToBooksInf(bookDAO.findBookByPublisherPage(page, 8, publisher_id)));
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<BookInfo> listBookByAuthorPage(Integer page, String typeSort, String author) {
		try {
			if (typeSort == null) {
				return ConvertModelToBean.mapBooksToBooksInf(bookDAO.findBookByTitlePage(page, 8, author));
			} else {
				if (typeSort.equals("1"))
					return SortBooks.sortBooksByTitle(ConvertModelToBean
							.mapBooksToBooksInf(bookDAO.findBookByTitlePage(page, 8, author)));
				return SortBooks.sortBooksByPublishDate(
						ConvertModelToBean.mapBooksToBooksInf(bookDAO.findBookByTitlePage(page, 8, author)));
			}
		} catch (Exception e) {
			return null;
		}
	}
}
