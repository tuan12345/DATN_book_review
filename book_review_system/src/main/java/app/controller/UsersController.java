package app.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import app.dto.UserInfo;
import app.service.impl.ExportExcel;
import app.service.impl.ImportExcel;
import app.util.TypeUtil;

@Controller
public class UsersController extends BaseController {
	private static final Logger logger = Logger.getLogger(UsersController.class);

	@RequestMapping("/users")
	public ModelAndView users(@RequestParam(value = "page", required = false) String page, Locale locale,
			@RequestParam(value = "importSuccess", required = false) String importSuccess,
			@RequestParam(value = "importError", required = false) String importError) {
		logger.info("load Users");
		ModelAndView model = new ModelAndView("users");
		model.addObject("pages", pages());
		if (importSuccess != null) {
			model.addObject("importMsg", messageSource.getMessage("import.admin.success", null, locale));
		}

		if (importError != null) {
			model.addObject("importMsg", messageSource.getMessage("import.admin.fail", null, locale));
		}
		if (page == null) {
			model.addObject("users", userService.loadUsers(1));
			model.addObject("currenPage", 1);
			model.addObject("pages", pages());
		} else {
			int p = Integer.parseInt(page);
			model.addObject("users", userService.loadUsers(p));
			model.addObject("currenPage", p);
			model.addObject("pages", pages());
		}
		if (userService.loadRowCount() == 0) {
			model.addObject("message", messageSource.getMessage("users.notfound", null, locale));
		}
		model.addObject("roles", roleService.loadRoles());
		model.addObject("excelType", TypeUtil.excelType);
		return model;
	}

	@RequestMapping("users/{id}")
	public @ResponseBody UserInfo getUser(@PathVariable String id) {
		UserInfo userInfo = userService.findUserInfoById(Integer.parseInt(id));
		return userInfo;
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable String id, Locale locale) {
		logger.info("delete User id:" + id);
		if (userService.findById(Integer.parseInt(id), false) == null) {
			return messageSource.getMessage("users.notfound", null, locale);
		}
		userService.deleteUser(Integer.parseInt(id));
		return messageSource.getMessage("users.deleted", null, locale);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String updateUser(@RequestBody UserInfo userInfo, Locale locale) {
		if (userService.findById(userInfo.getId(), false) == null) {
			return messageSource.getMessage("users.notfound", null, locale);
		}
		userService.updateUser(userInfo);
		return messageSource.getMessage("users.updated", null, locale);
	}

	@RequestMapping("/profile")
	public ModelAndView showMyProfile() {
		ModelAndView model = new ModelAndView("profile");
		model.addObject("userProfile", userService.findUserInfoById(currentUser().getId()));
		model.addObject("showFollow", false);
		return model;
	}

	@RequestMapping("/profile/{id}")
	public ModelAndView showProfile(@PathVariable String id, Locale locale, Principal principal) {
		if (principal == null) {
			return new ModelAndView("redirect:/login");
		}
		ModelAndView model = new ModelAndView("profile");
		UserInfo currentUser = userService.findUserInfoById(currentUser().getId());
		if (currentUser.getId() == Integer.parseInt(id)) {
			return new ModelAndView("redirect:/profile");
		}
		UserInfo user = userService.findUserInfoById(Integer.parseInt(id));
		if (user == null) {
			model.addObject("notFoundUser", messageSource.getMessage("users.notfound", null, locale));
			model.addObject("showFollow", false);
		} else {
			model.addObject("userProfile", user);
			model.addObject("currentUser", currentUser);
			model.addObject("showFollow", true);
			model.addObject("follow", followService.getFollow(currentUser.getId(), user.getId()));
		}

		return model;
	}

	@RequestMapping(value = "/deleteFollowUser", method = RequestMethod.POST)
	public ModelAndView deleteFollowUser(@RequestParam("id_follow") Integer idFollow,
			@RequestParam("id-userFollowed") int idUserFollowed) {
		followService.deleteFollow(idFollow);
		return new ModelAndView("redirect:/profile/" + idUserFollowed);
	}

	@RequestMapping(value = "/createFollowUser", method = RequestMethod.POST)
	public ModelAndView createFollowUser(@RequestParam("id-userFollowed") int idUserFollowed) {
		followService.createFollow(currentUser().getId(), idUserFollowed);
		return new ModelAndView("redirect:/profile/" + idUserFollowed);
	}

	@RequestMapping(value = "/resetPassword")
	public ModelAndView resetPassword() {
		ModelAndView model = new ModelAndView("forgotPassword");
		return model;
	}

	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
	public ModelAndView forgotPass(@ModelAttribute("userInfo") UserInfo userInfo, Locale locale) {
		ModelAndView model = new ModelAndView("forgotPassword");
		if (userService.updatePassword(userInfo, locale)) {
			model.addObject("msg", messageSource.getMessage("resetPassword-success", null, locale));
		} else {
			model.addObject("msg", messageSource.getMessage("user.email.notMatch", null, locale));
		}
		return model;
	}

	@RequestMapping("users/report")
	public ModelAndView exportUser() {
		List<UserInfo> userInfos = userService.loadAllUsers();
		return new ModelAndView(new ExportExcel(), "userInfos", userInfos);
	}

	@RequestMapping(value = "users/import", method = RequestMethod.POST)
	public ModelAndView importUsers(@RequestParam("file") MultipartFile file) {
		if (userService.saveUsers(ImportExcel.importExcel(file))) {
			return new ModelAndView("redirect:/users?importSuccess");
		}
		return new ModelAndView("redirect:/users?importError");
	}

	private int pages() {
		return (int) (Math.round(userService.loadRowCount() / 5 + 0.5));
	}
}