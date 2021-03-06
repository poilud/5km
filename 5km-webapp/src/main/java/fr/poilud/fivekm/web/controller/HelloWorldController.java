package fr.poilud.fivekm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
    public String helloWorld(Model model) {
		model.addAttribute("name", "Spiderman");
		model.addAttribute("role", "USER");
        return "index";
    }
	
	@RequestMapping("/dashboard")
    public String dashboardController(Model model) {
		model.addAttribute("name", "Spiderman");
		model.addAttribute("role", "USER");
        return "dashboard";
    }
	
	
}
