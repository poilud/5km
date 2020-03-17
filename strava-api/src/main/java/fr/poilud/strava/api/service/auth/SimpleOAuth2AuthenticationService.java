package fr.poilud.strava.api.service.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.poilud.strava.api.dto.StravaToken;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Simple implementation of {@link OAuth2AuthenticationService}
 * 
 * @author poilud
 * @version 1.0
 */
@RequiredArgsConstructor
public class SimpleOAuth2AuthenticationService implements OAuth2AuthenticationService<StravaToken> {

	private final String accessTokenUri;
	private final String grantType;
	private final RestTemplate accessTokenRestTemplate;

	@Override
	public StravaToken authenticate(@NonNull String clientId, @NonNull String clientSecret, @NonNull String accessCode) {
		if(accessTokenRestTemplate == null) {
			throw new NullPointerException("restTemplate use from authentication is null");
		}
		
		final HttpHeaders headers = new HttpHeaders();
		headers.add("client_id", clientId);
		headers.add("client_secret", clientSecret);
		headers.add("code", accessCode);
		headers.add("grant_type", grantType);
		
		final HttpEntity<String> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<StravaToken> response = accessTokenRestTemplate.exchange(accessTokenUri, HttpMethod.POST, entity, StravaToken.class);
			if(response != null && response.getStatusCode().is2xxSuccessful()) {
				return response.getBody();
			}
		} catch(RestClientException e) {
			throw e;
		}		
		return null;
	}
}
