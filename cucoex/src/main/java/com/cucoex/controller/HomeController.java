package com.cucoex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/","/index.html"})
	public String index() {
		return "index";
	}
	
	@GetMapping({"/login","/login.html"})
	public String login() {
		return "login";
	}
	
	@GetMapping({"/home","/home.html"})
	public String home() {
		return "home";
	}
	
	@GetMapping({"/buttons","/buttons.html"})
	public String buttons() {
		return "buttons";
	}
	
	@GetMapping({"/cards","/cards.html"})
	public String cards() {
		return "cards";
	}
	

    
    
	
}
