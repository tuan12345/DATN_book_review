package app.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;

@PropertySource("classpath:datasources.properties")
public class MailUtil {
	@Value("${mail.admin}")
	public static String mailName;

	public static SimpleMailMessage message(String from, String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		return message;
	}
}