package fr.poilud.fivekm.web.controller;

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

	@RequestMapping("/")
    public String home(Model model) {
        return "index";
    }
}
