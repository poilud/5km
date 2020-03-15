package fr.poilud.strava.api.client.factory;

import org.springframework.web.client.RestTemplate;

/**
 * Factory use to build custom {@link RestTemplate}
 * 
 * @author poilud
 * @version 1.0
 */
public interface RestTemplateFactory<T> {

	/**
	 * Build a {@link RestTemplate} object to consume Rest API.
	 * 
	 * @param accessToken
	 * @return
	 */
	RestTemplate buildAuthenticatedRestTemplate(T accessToken);
	
}
