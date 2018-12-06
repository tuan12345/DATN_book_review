package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.model.Publisher;
import app.service.PublisherService;

public class PublisherServiceImpl extends BaseServiceImpl implements PublisherService {

	@Override
	public Publisher findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publisher saveOrUpdate(Publisher entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Publisher entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Publisher> publishers() {
		try {
			return publisherDAO.Publishers();
		} catch (Exception e) {
			return null;
		}
		
	}

}
