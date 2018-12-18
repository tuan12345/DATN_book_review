package app.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.StandardBasicTypes;

import app.dao.BookDAO;
import app.dao.GenericDAO;
import app.model.Book;

public class BookDAOImpl extends GenericDAO<Integer, Book> implements BookDAO {
	private static final Logger logger = Logger.getLogger(BookDAOImpl.class);

	public BookDAOImpl() {
		super(Book.class);
	}

	public BookDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll(Integer page, Integer maxResult) {
		logger.info("load Books");
		return getSession().createQuery("From Book").setFirstResult(page != null ? (page - 1) * maxResult : 0)
				.setMaxResults(maxResult).list();
	}

	@Override
	public Long count() {
		logger.info("load Books");
		return (Long) getSession().createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public Book findByIdLock(int id, boolean lock) {
		if (lock) {
			return getSession().load(Book.class, id, LockMode.PESSIMISTIC_WRITE);
		}
		return getSession().find(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findBooksByTitle(String title) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.eq("tittle", title));
		List<Book> books = criteria.list();
		return books;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllBookTitle() {
		return getSession().createQuery("select tittle from Book").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> loadBooks() {

		return getSession().createQuery("From Book").getResultList();
	}

	@Override
	public List<Book> loadBooksByDateReview(int month, int year) {
		Criteria criteria = getSession().createCriteria(Book.class);
		Criteria subCritera = criteria.createCriteria("reviews", JoinType.INNER_JOIN);
		subCritera.add(Restrictions.sqlRestriction("MONTH({alias}.created_at) = ?", month, StandardBasicTypes.INTEGER));
		subCritera.add(Restrictions.sqlRestriction("YEAR({alias}.created_at) = ?", year, StandardBasicTypes.INTEGER));
		List<Book> books = subCritera.list();
		return subCritera.list();
	}

	@Override
	public List<Book> findBooksByKeyWorld(String keyWorld) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.like("title", keyWorld, MatchMode.START));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> ListAuthor() {
		return getSession().createQuery("select authorName from Book").getResultList();

	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.eq("authorName", author));
		return criteria.list();
	}

	@Override
	public List<Book> booksByAuthor(Integer page, Integer maxResult, String authorName) {
		return getSession().createCriteria(Book.class).add(Restrictions.eq("authorName", authorName))
				.setFirstResult(page != null ? (page - 1) * maxResult : 0).setMaxResults(maxResult).list();

	}

	@Override
	public List<Book> findBookByKeyWorldLike(String key) {
		Criteria criteria = getSession().createCriteria(Book.class)
				.add(Restrictions.like("authorName", "%" + key + "%"));
		return criteria.list();

	}

	@Override
	public List<Book> findBooksByCategoryId(int category_id) {
		Criteria criteria = getSession().createCriteria(Book.class).add(Restrictions.eq("category.id", category_id));
		return criteria.list();
	}

	@Override
	public List<Book> findBookByCategoryPage(Integer page, Integer maxResult, int category_id) {
		return getSession().createCriteria(Book.class).add(Restrictions.eq("category.id", category_id))
				.setFirstResult(page != null ? (page - 1) * maxResult : 0).setMaxResults(maxResult).list();
	}

	@Override
	public List<Book> findBooksByPublisherId(int publisher_id) {
		Criteria criteria = getSession().createCriteria(Book.class).add(Restrictions.eq("publisher.id", publisher_id));
		return criteria.list();

	}

	@Override
	public List<Book> findBookByPublisherPage(Integer page, Integer maxResult, int publisher_id) {
		return getSession().createCriteria(Book.class).add(Restrictions.eq("publisher.id", publisher_id))
				.setFirstResult(page != null ? (page - 1) * maxResult : 0).setMaxResults(maxResult).list();
	}

	@Override
	public List<Book> findBookByTitlePage(Integer page, Integer maxResult, String author) {
		return getSession().createCriteria(Book.class).add(Restrictions.eq("author", author))
				.setFirstResult(page != null ? (page - 1) * maxResult : 0).setMaxResults(maxResult).list();

	}

}
