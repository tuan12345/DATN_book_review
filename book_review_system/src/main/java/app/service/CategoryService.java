package app.service;

import java.util.List;

import app.dto.CategoryInfo;
import app.model.Category;

public interface CategoryService extends BaseService<Integer, Category> {
	List<String> categoryName();
	CategoryInfo findCategoryByName(String name);
	List<CategoryInfo> loadCategories();
}
