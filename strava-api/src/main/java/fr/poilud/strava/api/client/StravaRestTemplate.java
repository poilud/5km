package fr.poilud.strava.api.client;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

/**
 * Client use to consume Strava API
 * 
 * @author poilud
 * @version 1.0
 */
@RequiredArgsConstructor
public class StravaRestTemplate extends RestTemplate implements InitializingBean {

	private final String accessTokenUri;
	private final String clientId;
	private final String clientSecret;
	private final String grantType;
	private final String accessCode;
	
	private RestTemplate accessTokenRestTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		if(accessTokenRestTemplate == null) {
			final HttpHeaders headers = new HttpHeaders();
			headers.add("client_id", clientId);
			headers.add("client_secret", clientSecret);
			headers.add("code", accessCode);
			headers.add("grant_type", grantType);
			
			final HttpEntity<String> entity = new HttpEntity<>(headers);
			
			accessTokenRestTemplate = new RestTemplate();
			ResponseEntity<String> response = accessTokenRestTemplate.exchange(accessTokenUri, HttpMethod.POST, entity, String.class);
			
			
		}
		
	}
}
