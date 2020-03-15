package fr.poilud.strava.api.client.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import fr.poilud.strava.api.client.interceptor.StravaTokenInterceptor;
import fr.poilud.strava.api.dto.StravaToken;

/**
 * Unit tests for factory {@link StravaRestTemplateFactory}
 * 
 * @author poilud
 * @version 1.0
 */
public class StravaRestTemplateFactoryTest {

	private final StravaRestTemplateFactory factory = new StravaRestTemplateFactory();
	
	@Test
	public void given_token_when_buildAuthenticatedRestTemplate_then_return_restTemplate() {
		StravaToken token = StravaToken.builder()
				.type("Bearer")
				.accessToken(UUID.randomUUID().toString())
				.build();
		
		final StravaTokenInterceptor expectedInterceptor = new StravaTokenInterceptor(token.getType(), token.getAccessToken());
		
		RestTemplate restTemplate = factory.buildAuthenticatedRestTemplate(token);
		assertThat(restTemplate).isNotNull();
		assertThat(restTemplate.getInterceptors()).hasSize(1);
		assertThat(restTemplate.getInterceptors().get(0)).usingDefaultComparator().isEqualToComparingFieldByField(expectedInterceptor);
	}
	
	@Test
	public void given_null_token_when_buildAuthenticatedRestTemplate_do_throw_nullPointerException() {
		
		assertThrows(NullPointerException.class, () -> {
			factory.buildAuthenticatedRestTemplate(null);
		});
	}
	
	
}
