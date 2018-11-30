package app.controller;

import java.security.Principal;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import app.dto.BookInfo;
import app.dto.MarkInfo;
import app.dto.RequestInfo;
import app.util.DateUtil;

@Controller
public class BooksController extends BaseController {
	private static final Logger logger = Logger.getLogger(BooksController.class);

	@RequestMapping("books/{id}")
	public ModelAndView bookDetail(@PathVariable String id, Principal principal) {
		logger.info("Book Detail");
		ModelAndView model = new ModelAndView("bookDetail");
		if (principal != null) {
			model.addObject("currentUser", currentUser());
			MarkInfo markInfo = markService.findMarkByUserAndBook(currentUser().getId(), Integer.parseInt(id));
			model.addObject("markInfo", markInfo);
		}
		BookInfo bookInfo = bookService.findBookById(Integer.parseInt(id));
		model.addObject("bookInfo", bookInfo);
		model.addObject("categories", categoryService.categoryName());
		model.addObject("titles", bookService.getListTitle());
		model.addObject("reviews", reviewService.loadReviewsForBook(Integer.parseInt(id)));

		return model;
	}

	@RequestMapping("adminBook")
	public ModelAndView adminBook(@RequestParam(value = "success", required = false) String addSuccess, Locale locale) {
		ModelAndView model = new ModelAndView("adminBook");
		model.addObject("categories", categoryService.loadCategories());
		if (addSuccess != null) {
			model.addObject("addSuccessMsg", messageSource.getMessage("book.addSuccess", null, locale));
		}
		return model;
	}

	@RequestMapping(value = "books", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView addBook(@ModelAttribute("BookInfo") BookInfo bookInfo, HttpServletRequest request,
			@RequestParam("publishDate1") String date,
			@RequestParam(value = "image1", required = false) MultipartFile fileUpload) {
		String path = request.getSession().getServletContext().getRealPath("/") + "assets/img/book/";
		bookInfo.setPublishDate(DateUtil.parseDate(date));
		if (bookService.saveBook(bookInfo, fileUpload, path)) {
			return new ModelAndView("redirect:/adminBook?success");
		}
		return new ModelAndView("redirect:/adminBook");
	}

	@RequestMapping("/books/markReadBook")
	public ModelAndView markReadBook(@RequestParam("id-book") String idBook,
			@RequestParam("read-status") String readStatus) {
		markService.saveOrUpdate(Integer.parseInt(idBook), currentUser().getId(), Integer.parseInt(readStatus));
		return new ModelAndView("redirect:/books/" + idBook);
	}

	@RequestMapping("addReview")
	public ModelAndView addReview() {
		logger.info("Add Review");
		ModelAndView model = new ModelAndView("addReview");
		return model;
	}

	@RequestMapping("/requestBook")
	public ModelAndView showPageRequestBook(@RequestParam(value = "success", required = false) String sendSuccess,
			Locale locale) {
		logger.info("Add Request");
		ModelAndView model = new ModelAndView("requestBook");
		model.addObject("categories", categoryService.loadCategories());
		if (sendSuccess != null) {
			model.addObject("sendSuccessMsg", messageSource.getMessage("request.sendSuccess", null, locale));
		}
		return model;
	}

	@RequestMapping(value = "/sendRequest", method = RequestMethod.POST)
	public ModelAndView sendRequest(@ModelAttribute("RequestInfo") RequestInfo requestInfo,
			@RequestParam("idCategory") int idCategory) {
		logger.info("requestInfo:" + requestInfo);
		requestService.saveRequest(requestInfo, currentUser().getId(), idCategory);
		return new ModelAndView("redirect:/requestBook?success=success");

	}

}