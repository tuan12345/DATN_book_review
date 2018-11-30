package app.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import app.dto.MarkInfo;
import app.model.Mark;
import app.service.MarkService;

public class MarkServiceImpl extends BaseServiceImpl implements MarkService {
	private static final Logger logger = Logger.getLogger(MarkServiceImpl.class);

	@Override
	public MarkInfo findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public MarkInfo saveOrUpdate(int idBook, int idUser, int readStatus) {

		try {
			Mark mark = markDAO.findMarkByUserAndBook(idUser, idBook);
			if (mark == null) {
				Mark newMark = new Mark();
				newMark.setUser(userDAO.findByIdLock(idUser, true));
				newMark.setBook(bookDAO.findByIdLock(idBook, true));
				newMark.setReadStatus(readStatus);
				return ConvertModelToBean.mapMarkToMarkInfo(markDAO.saveOrUpdate(newMark));

			} else {
				mark.setReadStatus(readStatus);
				return ConvertModelToBean.mapMarkToMarkInfo(markDAO.saveOrUpdate(mark));
			}
		} catch (Exception e) {
			logger.info(e);
			throw e;
		}

	}

	@Override
	public boolean delete(MarkInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MarkInfo findMarkByUserAndBook(int idUser, int idBook) {
		try {
			return ConvertModelToBean.mapMarkToMarkInfo(getMarkDAO().findMarkByUserAndBook(idUser, idBook));
		} catch (Exception e) {
			logger.info(e);
			return null;
		}

	}

	@Override
	public MarkInfo saveOrUpdate(MarkInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
