package app.dao.impl;

import java.util.List;

import javax.validation.constraints.Null;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import app.dao.GenericDAO;
import app.dao.ReviewDAO;
import app.model.Book;
import app.model.Review;

public class ReviewDAOImpl extends GenericDAO<Integer, Review> implements ReviewDAO {
	private static final Logger logger = Logger.getLogger(ReviewDAOImpl.class);

	public ReviewDAOImpl() {
		super(Review.class);

	}

	public ReviewDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> loadReivews() {
		logger.info("load Reviews");
		return getSession().createQuery("from Review").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> loadReviewsForBook(int book_id) {
		logger.info("load Review by book_id");
		Criteria criteria = getSession().createCriteria(Review.class);
		criteria.add(Restrictions.eq("book.id", book_id));
		return criteria.list();
	}

	@Override
	public List<Review> loadReviewsByPage(Integer page, int maxResult, int book_id) {
		return getSession().createCriteria(Review.class).add(Restrictions.eq("book.id", book_id))
				.setFirstResult(page != null ? (page - 1) * maxResult : 0).setMaxResults(maxResult).list();
	}

	@Override
	public List<Review> loadReviewsUseful(Integer page, int book_id, int maxResult) {
		return getSession().createCriteria(Review.class)
				.add(Restrictions.and(Restrictions.eq("book.id", book_id),
						Restrictions.or(Restrictions.eq("numberOfStar", 4), Restrictions.eq("numberOfStar", 5))))
				.setFirstResult(page != null ? (page - 1) * maxResult : 0).setMaxResults(maxResult).list();
	}

	@Override
	public List<Review> loadAllReviewUseful() {
		return getSession().createCriteria(Review.class)
				.add(Restrictions.or(Restrictions.eq("numberOfStar", 4), Restrictions.eq("numberOfStar", 5))).list();

	}

}
