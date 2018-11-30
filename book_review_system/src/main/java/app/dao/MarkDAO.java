package app.dao;

import app.model.Mark;

public interface MarkDAO extends BaseDAO<Integer, Mark> {

	Mark findMarkByUserAndBook(int idUser, int idBook);

}
