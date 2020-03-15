package fr.poilud.strava.api.client.interceptor;

import java.io.IOException;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Interceptor use to add access token to headers request
 * 
 * @author poilud
 * @version 1.0
 */
public class StravaTokenInterceptor implements ClientHttpRequestInterceptor {

	private static final String DEFAULT_HEADER_NAME = "Authorization";
	private String headerValue;
	
	public StravaTokenInterceptor(final String tokenType, final String accessToken) {
		buildHeaderValue(tokenType, accessToken);
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		
		request.getHeaders().set(DEFAULT_HEADER_NAME, headerValue);
        return execution.execute(request, body);
	}
	
	public void buildHeaderValue(final String tokenType, final String accessToken) {
		if(StringUtils.isEmpty(tokenType)) {
			throw new IllegalArgumentException("token type must be not null and not empty");
		}
		if(StringUtils.isEmpty(accessToken)) {
			throw new IllegalArgumentException("acces token must be not null and not empty");
		}
		
		headerValue = new StringJoiner(StringUtils.SPACE)
				.add(tokenType)
				.add(accessToken)
				.toString();
		
	}

}
