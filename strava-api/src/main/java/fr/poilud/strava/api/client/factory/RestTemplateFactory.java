package fr.poilud.strava.api.client.factory;

import org.springframework.web.client.RestTemplate;

/**
 * Factory use to build custom {@link RestTemplate}
 * 
 * @author poilud
 * @version 1.0
 */
public interface RestTemplateFactory {

	/**
	 * Build {@link RestTemplate} object to obtain a access token and consume Rest API for specific access token
	 * @return
	 */
	RestTemplate buildAuthenticatedRestTemplate();
	
}
