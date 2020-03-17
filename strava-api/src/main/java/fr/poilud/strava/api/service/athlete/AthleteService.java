package fr.poilud.strava.api.service.athlete;

import fr.poilud.strava.api.dto.StravaAthlete;

/**
 * Service to consume strava athlete API
 * 
 * @author poilud
 * @version 1.0
 */
public interface AthleteService {

	StravaAthlete getAthlete();
}
