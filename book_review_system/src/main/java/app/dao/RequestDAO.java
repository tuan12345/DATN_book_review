package app.dao;

import java.util.List;

import app.model.Request;

public interface RequestDAO extends BaseDAO<Integer, Request> {
	Request findByRequest(int id, boolean lock);
	
	List<Request> loadRequestsNotHandle();

	List<Request> loadRequests();
}
