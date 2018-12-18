package app.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import app.dto.ActivityInfo;
import app.dto.CategoryInfo;

@Controller
public class HomeController extends BaseController {
	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public ModelAndView index(Principal principal, Locale locale) {
		logger.info("home page");
		ModelAndView model = new ModelAndView("home");
		if (principal != null) {
			String userName = principal.getName();
			List<ActivityInfo> activities = activityService.loadActivitiesByUserName(userName);
			if (activities.isEmpty()) {
				model.addObject("activityMsg", messageSource.getMessage("activities.empty", null, locale));
			}
			model.addObject("activities", activities);
			List<ActivityInfo> followerActivities = activityService
					.loadActivitiesFollowedByUserId(currentUser().getId());
			if (followerActivities.isEmpty()) {
				model.addObject("followerActivitiesMsg",
						messageSource.getMessage("followerActivities.empty", null, locale));
			}
			model.addObject("followerActivities", followerActivities);
		}
		model.addObject("titles", bookService.getListTitle());
		model.addObject("categories", categoryService.categoryName());
		model.addObject("currentUser", currentUser());

		model.addObject("listCategory", categoryService.loadCategories());
		model.addObject("publishers", publisherServicel.publishers());
		model.addObject("listAuthor", bookService.listAuthor());
		return model;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView loadBooks(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "typeSort", required = false) String typeSort,
			@RequestParam(value = "authorname", required = false) String authorName,
			@RequestParam(value = "category_id", required = false) Integer category_id,
			@RequestParam(value = "publisher_id", required = false) Integer publisher_id,
			@RequestParam(value = "typeshow", required = false) String typeShow, HttpServletRequest request) {
		logger.info("book page");
		ModelAndView model = new ModelAndView("books");
		String key = (String) request.getAttribute("key");
		String type_search = (String) request.getAttribute("type-serch");

		int tempCategoryId = 0;
		int tempPublisherId = 0;
		String typeDisplay = "";
		if (authorName != null) {
			typeDisplay = "1";
		}
		if (category_id != null) {
			tempCategoryId = category_id;
		}
		if (publisher_id != null) {
			tempPublisherId = publisher_id;
		}
		int curentPage = 1;
		if (key != null && type_search != null) {
			if (type_search.equals("title")) {
				model.addObject("books", bookService.listBookByAuthorPage(page, typeSort, key));
				model.addObject("page", bookService.page((long) bookService.findBookByTitle(key).size(), 8));
			}
			if (type_search.equals("category")) {
				CategoryInfo category = categoryService.findCategoryByName(key);
				model.addObject("books", bookService.listBookByCategory(page, typeSort, category.getId()));
				model.addObject("page",
						bookService.page((long) bookService.listBookByCategoryId(category.getId()).size(), 8));
			}
		} else {
			if (tempPublisherId != 0) {
				model.addObject("page",
						bookService.page((long) bookService.listBookByPublisherId(tempPublisherId).size(), 8));
				model.addObject("books", bookService.listBookByPublisherPage(page, typeSort, tempPublisherId));
				model.addObject("category_id", tempCategoryId);
				model.addObject("publisher_id", tempPublisherId);
			} else {
				if (authorName != null && authorName != "") {
					model.addObject("page",
							bookService.page((long) bookService.listBooksByAuthorName(authorName).size(), 8));
					model.addObject("books", bookService.listBookByAuthor(page, typeSort, authorName));
					model.addObject("authorname", authorName);
					model.addObject("typeshow", typeDisplay);
					model.addObject("tempCategoryId", category_id);
					model.addObject("publisher_id", tempPublisherId);
				} else {

					if (tempCategoryId != 0) {
						model.addObject("page",
								bookService.page((long) bookService.listBookByCategoryId(tempCategoryId).size(), 4));

						model.addObject("books", bookService.listBookByCategory(page, typeSort, category_id));
						model.addObject("category_id", tempCategoryId);
						model.addObject("publisher_id", tempPublisherId);
					}

					else {
						model.addObject("page", bookService.page(bookService.count(), 8));

						model.addObject("books", bookService.listBookByPage(page, typeSort));
						model.addObject("authorname", "");
						model.addObject("typeshow", typeDisplay);
						model.addObject("tempCategoryId", category_id);
						model.addObject("publisher_id", tempPublisherId);
					}
				}
			}
			if (page != null)
				curentPage = page;
			model.addObject("curentPage", curentPage);
			if (typeSort == null) {
				model.addObject("typeSort", "0");
			} else {
				model.addObject("typeSort", typeSort);
			}
		}
		model.addObject("titles", bookService.getListTitle());
		model.addObject("categories", categoryService.categoryName());
		model.addObject("listCategory", categoryService.loadCategories());
		model.addObject("publishers", publisherServicel.publishers());
		model.addObject("listAuthor", bookService.listAuthor());
		return model;
	}

	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("search") String key,
			@RequestParam(value = "type-search", required = false) String typeSearch, HttpServletRequest request) {
		String keyWords = key.trim();
		request.setAttribute("key", keyWords);
		request.setAttribute("type-serch", typeSearch);
		return "forward:/books";

		/*
		 * logger.info("type search-----"+typeSearch);
		 * 
		 * ModelAndView model = new ModelAndView("books");
		 * model.addObject("categories", categoryService.categoryName());
		 * model.addObject("titles", bookService.getListTitle());
		 * model.addObject("key", key); model.addObject("typeSearch",
		 * typeSearch); if (typeSearch.equals("title")) {
		 * model.addObject("books", bookService.findBookByTitle(keyWords)); } if
		 * (typeSearch.equals("category")) { CategoryInfo category =
		 * categoryService.findCategoryByName(keyWords);
		 * model.addObject("books",
		 * bookService.listBooksByCategoryId(category.getId())); } return model;
		 */
	}
}
