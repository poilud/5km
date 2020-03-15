package fr.poilud.strava.api.client.factory;

import org.springframework.web.client.RestTemplate;

import fr.poilud.strava.api.client.interceptor.StravaTokenInterceptor;
import fr.poilud.strava.api.dto.StravaToken;
import lombok.NonNull;

/**
 * Implementation of {@link RestTemplateFactory} to consume Strava API
 * 
 * @author poilud
 * @version 1.0
 */
public class StravaRestTemplateFactory implements RestTemplateFactory<StravaToken> {

	@Override
	public RestTemplate buildAuthenticatedRestTemplate(@NonNull StravaToken accessToken) {
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new StravaTokenInterceptor(accessToken.getType(), accessToken.getAccessToken()));
		return restTemplate;
	}


	
	

	
}
