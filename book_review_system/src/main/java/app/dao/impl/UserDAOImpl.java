package app.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import app.dao.GenericDAO;
import app.dao.UserDAO;
import app.model.User;

public class UserDAOImpl extends GenericDAO<Integer, User> implements UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	public UserDAOImpl() {
		super(User.class);
	}

	public UserDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> loadUsers(int page) {
		logger.info("load User in DAO");
		return getSession().createQuery("from User").setFirstResult(page).setMaxResults(5).getResultList();
	}

	@Override
	public int loadRowsCount() {
		return getSession().createQuery("from User").getResultList().size();
	}

	@Override
	public User findByIdLock(int id, boolean lock) {
		if (lock) {
			return getSession().get(User.class, id, LockMode.PESSIMISTIC_WRITE);
		}
		return getSession().get(User.class, id);
	}

	@Override
	public User loadUserByUserName(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", username));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	public User findByUserNameAndEmail(String userName, String email) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("email", email));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	public List<User> loadAllUsers() {
		return getSession().createQuery("from User").getResultList();
	}

}
