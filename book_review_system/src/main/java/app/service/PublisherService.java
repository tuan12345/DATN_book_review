package app.service;

import java.util.List;

import app.model.Publisher;

public interface PublisherService extends BaseService<Integer, Publisher> {
	List<Publisher> publishers();

}
