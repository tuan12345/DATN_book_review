package app.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import app.dao.GenericDAO;
import app.dao.MarkDAO;
import app.model.Activity;
import app.model.Mark;

public class MarkDaoImpl extends GenericDAO<Integer, Mark> implements MarkDAO {
	private static final Logger logger = Logger.getLogger(MarkDaoImpl.class);

	public MarkDaoImpl() {
		super(Mark.class);

	}

	public MarkDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public Mark findMarkByUserAndBook(int idUser, int idBook) {
		try {
			Criteria criteria = getSession().createCriteria(Mark.class);
			criteria.createAlias("user", "u");
			criteria.createAlias("book", "b");
			criteria.add(Restrictions.eq("u.id", idUser));
			criteria.add(Restrictions.eq("b.id", idBook));
			return (Mark) criteria.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		
	}

}
