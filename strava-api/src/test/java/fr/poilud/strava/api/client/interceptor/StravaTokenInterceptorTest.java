package fr.poilud.strava.api.client.interceptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Unit tests for {@link StravaTokenInterceptor}
 * 
 * @author poilud
 * @version 1.0
 */
public class StravaTokenInterceptorTest {

	@Test
	public void given_interceptor_when_init_do_works() {
		new StravaTokenInterceptor("Bearer", UUID.randomUUID().toString());
	}
	
	@ParameterizedTest
	@MethodSource("provideInvalidData")
	public void given_interceptor_with_invalid_params_when_init_do_throw_illegalArgumentException(String type, String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			new StravaTokenInterceptor(type, value);
		});
	}
	
	@Test
	public void given_request_and_interceptor_when_intercept_then_return_excepted_header() throws IOException {
		final String headerKey = "Authorization";
		final String headerValue = UUID.randomUUID().toString();
		
		Request request = new Request();
		StravaTokenInterceptor interceptor = new StravaTokenInterceptor("Bearer", headerValue);
		
		interceptor.intercept(request, null, new RequestExecution());
		HttpHeaders headers = request.getHeaders();
		
		assertThat(headers).isNotNull();
		assertThat(headers.containsKey(headerKey)).isTrue();
		assertThat(headers.get(headerKey)).hasSize(1);
		assertThat(headers.get(headerKey).get(0)).isEqualTo("Bearer " + headerValue);
	}
	
	private static Stream<Arguments> provideInvalidData() {
		return Stream.of(
				Arguments.of(null, UUID.randomUUID().toString()),
				Arguments.of("", UUID.randomUUID().toString()),
				Arguments.of(" ", UUID.randomUUID().toString()),
				Arguments.of("Bearer", null),
				Arguments.of("Bearer", ""),
				Arguments.of("Bearer", " ")
				);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	private class Request implements HttpRequest {

		HttpHeaders headers = new HttpHeaders();
		
		@Override
		public HttpHeaders getHeaders() {
			return headers;
		}

		@Override
		public String getMethodValue() {
			return HttpMethod.POST.name();
		}

		@Override
		public URI getURI() {
			return URI.create("http://www.example.com");
		}
	}
	
	private class RequestExecution implements ClientHttpRequestExecution {

		@Override
		public ClientHttpResponse execute(HttpRequest request, byte[] body) throws IOException {
			return null;
		}
		
	}
	
}
