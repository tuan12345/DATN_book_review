package app.service;

import java.util.List;

import app.dto.RequestInfo;

public interface RequestService extends BaseService<Integer, RequestInfo> {
	RequestInfo saveRequest(RequestInfo requestInfo, int idUser, int idCategory);

	List<RequestInfo> loadRequestsNotHandled();

	List<RequestInfo> loadRequests();
	
	boolean deleteRequest(int requestId);
	
	RequestInfo updateRequest(int id, int status);
}
