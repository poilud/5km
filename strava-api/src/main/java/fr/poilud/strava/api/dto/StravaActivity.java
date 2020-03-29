package fr.poilud.strava.api.dto;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class StravaActivity implements Serializable {

	private static final long serialVersionUID = -8944323494182841606L;
	
	@JsonProperty("id")
	private Long identifier;
	
	private StravaMetaAthlete athlete;
	private String name;
	private Float distance;
	
	@JsonProperty("moving_time")
	private Integer movingTime;
	
	@JsonProperty("elapsed_time")
	private Integer elapsedTime;
	
	private String type;
	
	@JsonProperty("start_date")
	private String startDate;
	
	@JsonProperty("start_latlng")
	private Collection<Float> startLatLng;
	
	@JsonProperty("end_latlng")
	private Collection<Float> endLatLng;
		
	@JsonProperty("average_speed")
	private Float averageSpeed;
	
	@JsonProperty("max_speed")
	private Float maxSpeed;
	
}
