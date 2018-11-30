package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import app.dto.CategoryInfo;
import app.model.Category;
import app.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {
	private static final Logger logger = Logger.getLogger(CommentServiceImpl.class);

	@Override
	public Category findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Category entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> categoryName() {
		try {
			return categoryDAO.nameCategory();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public CategoryInfo findCategoryByName(String name) {
		try {
			return ConvertModelToBean.mapCategoryToCategoryInfo(categoryDAO.findCategoryByName(name));
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<CategoryInfo> loadCategories() {
		try {
			List<Category> categories = categoryDAO.loadCategories();
			List<CategoryInfo> categoryInfos = new ArrayList<>();
			for (Category category : categories) {
				categoryInfos.add(new CategoryInfo(category.getId(), category.getName()));
			}
			return categoryInfos;
		} catch (Exception e) {
			logger.error(e);
			return Collections.emptyList();
		}
	}

}
