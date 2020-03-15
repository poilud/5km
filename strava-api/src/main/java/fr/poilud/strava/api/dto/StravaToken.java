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
public class StravaToken implements Serializable {

	private static final long serialVersionUID = -4704561766184460240L;
	
	@JsonProperty("token_type")
	private String type;
	
	@JsonProperty("expires_at")
	private Long expiryDate;
	
	@JsonProperty("expires_in")
	private Long expiryDuration;
	
	@JsonProperty("refresh_token")
	private String refreshToken;
	
	@JsonProperty("access_token")
	private String accessToken;
}
