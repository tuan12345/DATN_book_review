package app.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import app.dao.GenericDAO;
import app.dao.ReviewDAO;
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

}
