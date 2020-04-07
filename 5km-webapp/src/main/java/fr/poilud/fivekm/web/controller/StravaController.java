package fr.poilud.fivekm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StravaController {

	@RequestMapping("/strava/register")
    public String register(
    		@RequestParam(name = "state", required = false, defaultValue = "") String state, 
    		@RequestParam(name = "code", required = true) String code, 
    		@RequestParam(name = "scope", required = true) String scope, 
    		Model model) {
		System.out.println("strava register....");
		System.out.println("strava state : " + state);
		System.out.println("strava code : " + code);
		System.out.println("strava scope : " + scope);
		
        return "dashboard";
    }
}
