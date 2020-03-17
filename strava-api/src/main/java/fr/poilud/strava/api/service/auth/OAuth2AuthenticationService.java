package fr.poilud.strava.api.service.auth;

/**
 * Service use to provide a Strava oAuth2 authentication
 * 
 * @author poilud
 * @version 1.0
 */
public interface OAuth2AuthenticationService<T> {

	/**
	 * Obtain an authenticated object from Strava API
	 * @param accessTokenUri
	 * @param clientId
	 * @param clientSecret
	 * @param grantType
	 * @param accessCode
	 * @return
	 */
	T authenticate(String clientId, String clientSecret, String accessCode);
}
