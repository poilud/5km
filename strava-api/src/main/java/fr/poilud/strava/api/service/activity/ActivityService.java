package fr.poilud.strava.api.service.activity;

import java.time.LocalDateTime;
import java.util.Collection;

import fr.poilud.strava.api.dto.StravaActivity;

/**
 * Service to consume strava activities API
 * 
 * @author poilud
 * @version 1.0
 */
public interface ActivityService {

	Collection<StravaActivity> findActivities(LocalDateTime before, LocalDateTime after, int maxItems, int pageNumber);
	Collection<StravaActivity> findActivitiesBefore(LocalDateTime before, int maxItems, int pageNumber);
	Collection<StravaActivity> findActivitiesAfter(LocalDateTime after, int maxItems, int pageNumber);
	
}
