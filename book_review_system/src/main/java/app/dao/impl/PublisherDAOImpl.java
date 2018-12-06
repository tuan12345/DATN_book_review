package app.dao.impl;

import java.util.List;

import app.dao.GenericDAO;
import app.dao.PublisherDAO;
import app.model.Publisher;

public class PublisherDAOImpl extends GenericDAO<Integer, Publisher> implements PublisherDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Publisher> Publishers() {
		return getSession().createQuery("from Publisher").getResultList();
	}

}
