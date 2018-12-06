package app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.dto.UserInfo;
import app.util.SignUpResponseTransfer;

@Controller
public class SignUpController extends BaseController {
	private static final Logger logger = Logger.getLogger(SignUpController.class);

	@RequestMapping(value = "/signUp", method = RequestMethod.POST/*, produces = { MediaType.APPLICATION_JSON_VALUE }*/)
	public @ResponseBody SignUpResponseTransfer singUp(@ModelAttribute("userinfo") UserInfo userInfo) {
		
		logger.info("----concac"+ userInfo);
		logger.info("----concac222"+ userInfo.getEmail());
		SignUpResponseTransfer signUp = new SignUpResponseTransfer();
		signUp.setCheckEmail("");
		signUp.setCheckUsername("");
		signUp.setNotifivation("");
		if (userService.findUserInfoByUsername(userInfo.getUserName()) != null) {
			signUp.setCheckUsername("User already exists");
		}
		if (userService.findUserInfoByEmail(userInfo.getEmail()) != null) {
			signUp.setCheckEmail("Email  already exists");
		} else {
			if (userService.findUserInfoByUsername(userInfo.getUserName()) == null
					&& userService.findUserInfoByEmail(userInfo.getEmail()) == null) {
				userService.saveUsers(userInfo);
				signUp.setNotifivation("Sign Up Success  !");
			}
		}
		return signUp;
	}
	/*@ResponseBody
	public String test(){
		return "hello";
	}*/

}
