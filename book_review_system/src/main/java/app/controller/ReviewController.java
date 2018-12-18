package app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.dto.ResponseReviewInfo;
import app.dto.ReviewInfo;
import app.helper.SendNotification;

@Controller
public class ReviewController extends BaseController {
	private static final Logger logger = Logger.getLogger(ReviewController.class);

	@RequestMapping(value = "/books/{bookId}/reviews/add", method = RequestMethod.POST)
	public ModelAndView AddReview(@ModelAttribute("reviewInfo") ReviewInfo reviewInfo,
			@PathVariable("bookId") int bookId) {
		logger.info("content-------------"+reviewInfo.getContent());
			reviewService.createReview(reviewInfo, bookId, currentUser().getId());
			ReviewInfo reInfo = reviewService.findUserRivew(currentUser().getId(), bookId);
			activityService.saveReviewActivity(reInfo, currentUser().getId());
		return new ModelAndView("redirect:/books/" + bookId);
	}
	@RequestMapping(value="/reviewAjax",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody List<ResponseReviewInfo> loadReviewAjax(@RequestParam(value="id_book",required=false) String book_id,@RequestParam("page") String page,@RequestParam(value="userful",required=false) String typeUserful){
		if(typeUserful!=null&&typeUserful.equals("userful")){
			return reviewService.loadReviewUseful(Integer.parseInt(page),Integer.parseInt(book_id), 1);
		}
		else{
		return reviewService.loadAjxReview(Integer.parseInt(page), Integer.parseInt(book_id), 5);
		}
	}

	@RequestMapping(value = "/review")
	public ModelAndView redirectAddReview(@RequestParam(value = "idBook", required = false) Integer idBook) {
		logger.info("id book" + idBook);
		int idUser = currentUser().getId();
		logger.info("id User" + idUser);
		ReviewInfo reviewInfo = reviewService.findUserRivew(idUser, idBook);
		ModelAndView modelAndView = new ModelAndView("addReview");
		modelAndView.addObject("reviewInfo", reviewInfo);
		modelAndView.addObject("idBook", idBook);
		modelAndView.addObject("titles", bookService.getListTitle());
		modelAndView.addObject("categories", categoryService.categoryName());
		if (reviewInfo.getContent() == null) {
			modelAndView.addObject("hidden", 1);
			modelAndView.addObject("idReview", 0);
		} else {
			modelAndView.addObject("hidden", 2);
			modelAndView.addObject("idReview", reviewInfo.getId());
		}
		return modelAndView;
	}
}
