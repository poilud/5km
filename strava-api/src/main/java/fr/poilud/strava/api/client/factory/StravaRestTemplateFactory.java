package fr.poilud.strava.api.client.factory;

import org.springframework.web.client.RestTemplate;

import fr.poilud.strava.api.dto.StravaToken;
import fr.poilud.strava.api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

/**
 * Implementation of {@link RestTemplateFactory} to consume Strava API
 * 
 * @author poilud
 * @version 1.0
 */
@RequiredArgsConstructor
public class StravaRestTemplateFactory implements RestTemplateFactory {

	private final AuthenticationService authenticationService;
	
	@Override
	public RestTemplate buildAuthenticatedRestTemplate() {
		StravaToken token = authenticationService.authenticate();
		if(token != null) {
			RestTemplate restTemplate = new RestTemplate();
			//restTemplate.setInterceptors(interceptors);
		}
		return null;
	}

	
	

	
}
