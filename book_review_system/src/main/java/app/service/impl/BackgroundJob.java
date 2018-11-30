package app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import app.service.RequestService;
import app.util.MailUtil;

@Configuration
@EnableScheduling
@PropertySource("classpath:datasources.properties")
public class BackgroundJob {
	@Autowired
	private MailSender mailSender;
	@Autowired
	private RequestService requestService;
	@Value("${mail.admin}")
	private String adminMail;
	@Value("${mail.username}")
	private String mailName;
	@Value("${request.handle}")
	private String requestHandle;
	@Value("${request.not.handle}")
	private String requestNotHandle;

	// Send Request 12am EveryDay
	@Scheduled(cron = "${scheduling.job.cron}")
	public void sendListRequest() {
		try {
			SimpleMailMessage message = MailUtil.message(mailName, adminMail, requestHandle,
					requestNotHandle + requestService.loadRequestsNotHandled().size());
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}