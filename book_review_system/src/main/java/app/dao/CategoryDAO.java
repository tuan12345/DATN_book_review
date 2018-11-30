package app.dao;

import java.util.List;

import app.model.Category;

public interface CategoryDAO extends BaseDAO<Integer, Category> {
	List<String> nameCategory();
	List<Category> loadCategories();
	Category findCategoryByName(String categoryName);
}
