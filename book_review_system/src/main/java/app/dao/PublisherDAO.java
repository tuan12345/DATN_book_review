package app.dao;

import java.util.List;

import app.model.Publisher;

public interface PublisherDAO extends BaseDAO<Integer, Publisher> {
	List<Publisher> Publishers();

}
