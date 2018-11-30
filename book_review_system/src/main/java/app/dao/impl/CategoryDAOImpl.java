package app.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import app.dao.CategoryDAO;
import app.dao.GenericDAO;
import app.model.Category;

public class CategoryDAOImpl extends GenericDAO<Integer, Category> implements CategoryDAO {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CategoryDAOImpl.class);

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> nameCategory() {
		return getSession().createQuery("select name from Category").getResultList();
	}

	@Override
	public Category findCategoryByName(String categoryName) {
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("name", categoryName));
		Category books = (Category) criteria.uniqueResult();
		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> loadCategories() {
		return getSession().createQuery("from Category").getResultList();
	}

}
