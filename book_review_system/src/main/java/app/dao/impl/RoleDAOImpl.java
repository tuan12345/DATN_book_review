package app.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import app.dao.GenericDAO;
import app.dao.RoleDAO;
import app.model.Role;

public class RoleDAOImpl extends GenericDAO<Integer, Role> implements RoleDAO {

	private static final Logger logger = Logger.getLogger(RoleDAOImpl.class);

	public RoleDAOImpl() {
		super(Role.class);
	}

	public RoleDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> loadRoles() {
		logger.info("load Roles");
		return getSession().createQuery("from Role").getResultList();
	}

}
