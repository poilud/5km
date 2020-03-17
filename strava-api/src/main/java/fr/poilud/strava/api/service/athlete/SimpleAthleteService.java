package fr.poilud.strava.api.service.athlete;

import org.springframework.web.client.RestTemplate;

import fr.poilud.strava.api.dto.StravaAthlete;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Simple implementation of {@link AthleteService}
 * 
 * @author poilud
 * @version 1.0
 */
@RequiredArgsConstructor
public class SimpleAthleteService implements AthleteService {

	@NonNull
	private final String athleteUri;
	
	@NonNull
	private final RestTemplate authenticatedRestTemplate;
	
	@Override
	public StravaAthlete getAthlete() {
		return authenticatedRestTemplate.getForObject(athleteUri, StravaAthlete.class);
	}

}
