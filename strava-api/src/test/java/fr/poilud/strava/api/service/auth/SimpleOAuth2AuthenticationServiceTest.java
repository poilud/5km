package fr.poilud.strava.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import fr.poilud.strava.api.dto.StravaToken;

/**
 * Unit tests for {@link SimpleOAuth2AuthenticationService}
 * 
 * @author poilud
 * @version 1.0
 */
public class SimpleOAuth2AuthenticationServiceTest {

	private SimpleOAuth2AuthenticationService service;
	private RestTemplate restTemplateMocked;

	@BeforeEach
	public void setUp() throws Exception {
		restTemplateMocked = mock(RestTemplate.class);
		service = new SimpleOAuth2AuthenticationService("http://wwww.example.com/token", "password", restTemplateMocked);
	}

	@Test
	public void given_authentication_data_when_authenticate_then_return_expected_token_object() {

		// Given
		StravaToken expectedToken = StravaToken.builder()
				.type("Bearer")
				.expiryDate(Long.valueOf("1584223022"))
				.expiryDuration(Long.valueOf("21600"))
				.accessToken(UUID.randomUUID().toString())
				.refreshToken(UUID.randomUUID().toString())
				.build();
		ResponseEntity<StravaToken> expectedResponse = new ResponseEntity<StravaToken>(expectedToken, HttpStatus.OK);
		
		// When
		when(restTemplateMocked.exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any())).thenReturn(expectedResponse);
		StravaToken token = service.authenticate("123456", "myPassword", "myCode");

		// Then
		assertThat(token).isNotNull();
		assertThat(token).isEqualTo(expectedToken);
		verify(restTemplateMocked, times(1)).exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any());
	}

	@Test
	public void given_unauthorized_authentication_data_when_authenticate_then_return_expected_token_object() {

		ResponseEntity<StravaToken> expectedResponse = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		when(restTemplateMocked.exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any())).thenReturn(expectedResponse);
		StravaToken token = service.authenticate("123456", "myPassword", "myCode");

		assertThat(token).isNull();
		verify(restTemplateMocked, times(1)).exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any());
	}

	@Test
	public void given_authentication_data_when_authenticate_then_return_null_token_object() {

		
		when(restTemplateMocked.exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any())).thenReturn(null);
		
		StravaToken token = service.authenticate("123456", "myPassword", "myCode");

		assertThat(token).isNull();
		verify(restTemplateMocked, times(1)).exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any());
	}

	@Test
	public void given_authentication_data_when_authenticate_throw_restClientException() {

		doThrow(new RestClientResponseException("unathorized", 401, "unathorized", null, null, null)).when(restTemplateMocked).exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any());
		assertThrows(RestClientException.class, () -> {
			service.authenticate("123456", "myPassword", "myCode");
		});
		verify(restTemplateMocked, times(1)).exchange(anyString(), any(HttpMethod.class), any(), ArgumentMatchers.<Class<StravaToken>>any());
	}

	@Test
	public void given_null_restTemplate_when_authenticate_do_throw_nullPointerException() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			service = new SimpleOAuth2AuthenticationService("http://wwww.example.com/token", "password", null);
			service.authenticate("123456", "myPassword", "myCode");
		});
		assertThat(exception.getMessage()).isEqualTo("restTemplate use from authentication is null");
	}

	@ParameterizedTest
	@MethodSource("provideNullAuthenticateData")
	public void given_null_authentication_data_when_authenticate_do_throw_nullPointerException(final String clientId, final String clientSecret, final String clientCode) {
		assertThrows(NullPointerException.class, () -> {
			service.authenticate(clientId, clientSecret, clientCode);
		});
	}

	private static Stream<Arguments> provideNullAuthenticateData() {
		return Stream.of(
				Arguments.of(null, "myPassword", "myCode"),
				Arguments.of("123456", null, "myCode"),
				Arguments.of("123456", "myPassword", null)
				);
	}


}
