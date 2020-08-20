package com.cucoex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	// Inicio de la aplicacion mosyrando el tablero
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
	
	@GetMapping({"/tables","/tables.html"})
	public String tables() {
		return "tabla";
	}
    
	@GetMapping({"/catUser","/catUser.html"})
	public String catUser() {
		return "catUser/catUser";
	}
    
	@GetMapping({"/catUser2","/catUser2.html"})
	public String catUser2() {
		return "catUser/catUser2";
	}
	
}


