package fr.poilud.strava.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class StravaAthlete extends StravaMetaAthlete {

	private static final long serialVersionUID = -4663904806171211134L;
	
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

	@Builder
	public StravaAthlete(Long identifier, String username, String firstname, String lastname, String city, String state,
			String country, String sex, String profileMediumUri, String profileUri) {
		super(identifier);
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.country = country;
		this.sex = sex;
		this.profileMediumUri = profileMediumUri;
		this.profileUri = profileUri;
	}
}
