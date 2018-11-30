package app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.dto.BookChart;

@Controller
public class ChartsController extends BaseController {
	private static final Logger logger = Logger.getLogger(ChartsController.class);

	@RequestMapping("/charts")
	public ModelAndView showChart() {
		ModelAndView model = new ModelAndView("charts");
		logger.info("Show Chart");
		return model;
	}

	@RequestMapping("/reviewChart/{month}/{year}")
	public @ResponseBody List<BookChart> reviewChart(@PathVariable("month") String month,
			@PathVariable("year") String year) {
		List<BookChart> charts = bookService.loadBooksByDate(Integer.parseInt(month), Integer.parseInt(year));
		return charts;
	}
}
