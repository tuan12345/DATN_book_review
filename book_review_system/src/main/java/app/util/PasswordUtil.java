package app.util;

import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
	public static String passwordEndcode(String noopPassword){
		BCryptPasswordEncoder bCryptPassword = new BCryptPasswordEncoder();
		return bCryptPassword.encode(noopPassword);
	}
	
	public static int randomPassword(){
		Random rand = new Random();
		return 100000 + rand.nextInt(999999 - 100000);
	}
	
	public static final String DEFAULT_PASSWORD = "123456";
}