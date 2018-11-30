package app.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.dto.UserInfo;
import app.util.GooglePojo;
import app.util.GoogleUtils;

@Controller
public class LoginController extends BaseController {
	private static final Logger logger = Logger.getLogger(UsersController.class);

	@Autowired
	GoogleUtils googleUtils;

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, Locale locale) {
		ModelAndView model = new ModelAndView("login");
		if (error != null) {
			logger.info("Login Fail!");
			model.addObject("msg", messageSource.getMessage("login.fail", null, locale));
		}
		return model;
	}

	@RequestMapping("/login-google")
	public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			return "redirect:/login?error";
		}
		GooglePojo googlePojo = googleUtils.getUserInfo(googleUtils.getToken(code));
		UserInfo userInfo = userService.findUserInfoByUsername(googlePojo.getEmail());
		if (userInfo == null && !userService.saveUser(googlePojo, code)) {
			return "redirect:/login?error";
		}
		googleUtils.sessionLogin(googleUtils.buildUser(googlePojo), request);
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public ModelAndView logout(Locale locale) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("msg", messageSource.getMessage("logout", null, locale));
		return model;
	}

	@RequestMapping("/adminHome")
	public String adminHome() {
		return "adminHome";
	}
}