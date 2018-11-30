package app.service;

import app.dto.MarkInfo;

public interface MarkService extends BaseService<Integer, MarkInfo> {
	MarkInfo findMarkByUserAndBook(int idUser, int idBook);

	public MarkInfo saveOrUpdate(int idBook, int idUser, int readStatus);

}
