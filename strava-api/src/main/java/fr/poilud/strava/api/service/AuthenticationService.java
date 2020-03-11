package fr.poilud.strava.api.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.poilud.strava.api.dto.StravaToken;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationService implements InitializingBean {

	private final String accessTokenUri;
	private final String clientId;
	private final String clientSecret;
	private final String grantType;
	private final String accessCode;
	
	private RestTemplate accessTokenRestTemplate;
	
	public StravaToken authenticate() throws RestClientException {
		final HttpHeaders headers = new HttpHeaders();
		headers.add("client_id", clientId);
		headers.add("client_secret", clientSecret);
		headers.add("code", accessCode);
		headers.add("grant_type", grantType);
		
		final HttpEntity<String> entity = new HttpEntity<>(headers);
		
		accessTokenRestTemplate = new RestTemplate();
		ResponseEntity<StravaToken> response = accessTokenRestTemplate.exchange(accessTokenUri, HttpMethod.POST, entity, StravaToken.class);
		if(response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		}
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(accessTokenRestTemplate == null) {
			accessTokenRestTemplate = new RestTemplate();
		}
		
	}
}
