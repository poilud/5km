package fr.poilud.strava.api.dto;

import java.io.Serializable;

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
public class StravaAthlete implements Serializable {

	private static final long serialVersionUID = -4663904806171211134L;
	
	@JsonProperty("id")
	private Long identifier;
	private String username;
	private String firstname;
	private String lastname;
	private String city;
	private String state;
	private String country;
	private String sex;
	
	@JsonProperty("profile_medium")
	private String profileMediumUri;

	@JsonProperty("profile")
	private String profileUri;

}
