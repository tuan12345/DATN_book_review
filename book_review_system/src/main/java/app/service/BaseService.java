package app.service;

import java.io.Serializable;

public interface BaseService<PK, T> {
	public T findById(Serializable key, boolean lock);

	public T saveOrUpdate(T entity);

	public boolean delete(T entity);

	

}
