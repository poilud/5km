package fr.poilud.fivekm.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Use to configure access of Bootstrap static resource
 * 
 * @author poilud
 * @version 1.0
 */
@Configuration
public class FiveKmWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/jquery/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.4.1/");

		registry.addResourceHandler("/popper/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/popper.js/1.15.0/umd/");

		registry.addResourceHandler("/bootstrap/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.3.1/");

	}
}
