package app.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@PropertySource("classpath:datasources.properties")
public class GoogleUtils {
	
	@Value("${GOOGLE_CLIENT_ID}")
	private String GOOGLE_CLIENT_ID;
	@Value("${GOOGLE_CLIENT_SECRET}")
	private String GOOGLE_CLIENT_SECRET;
	@Value("${GOOGLE_REDIRECT_URI}")
	private String GOOGLE_REDIRECT_URI;
	@Value("${GOOGLE_LINK_GET_TOKEN}")
	private String GOOGLE_LINK_GET_TOKEN;
	@Value("${GOOGLE_LINK_GET_USER_INFO}")
	private String GOOGLE_LINK_GET_USER_INFO;
	@Value("${GOOGLE_GRANT_TYPE}")
	private String GOOGLE_GRANT_TYPE;

	public String getToken(final String code) throws ClientProtocolException, IOException {
		String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
						.bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID).add("client_secret", GOOGLE_CLIENT_SECRET)
								.add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code).add("grant_type", GOOGLE_GRANT_TYPE)
								.build())
						.execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");
		return node.textValue();
	}

	public GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		GooglePojo googlePojo = mapper.readValue(response, GooglePojo.class);
		System.out.println(googlePojo);
		return googlePojo;
	}

	public UserDetails buildUser(GooglePojo googlePojo) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails userDetail = new User(googlePojo.getEmail(), "", enabled, accountNonExpired, credentialsNonExpired,
						accountNonLocked, authorities);
		return userDetail;
	}

	public void sessionLogin(UserDetails userDetail, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
						userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}