package fr.poilud.fivekm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main controller use to publish welcome page
 * 
 * @author poilud
 * @version 1.0
 */
@Controller
public class HomeController {

	@Autowired
	private Environment env;
	
	@RequestMapping("/")
    public String home(Model model) {
		model.addAttribute("authorizationUri", buildAuthorizationUri());
        return "index";
    }
	
	private String buildAuthorizationUri() {
		StringBuilder uriBuilder = new StringBuilder(env.getProperty("strava.authorization.uri"));
		uriBuilder.append("?client_id=").append(env.getProperty("strava.client.id"));
		uriBuilder.append("&redirect_uri=").append(env.getProperty("strava.authorization.redirect_uri"));
		uriBuilder.append("&response_type=").append(env.getProperty("strava.authorization.response_type"));
		uriBuilder.append("&scope=").append(env.getProperty("strava.authorization.scope"));
		
		return uriBuilder.toString();
	}
}
