package com.cucoex.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cucoex.dto.ChangePasswordForm;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.User;

@Controller
public class HomeController {
	
	
	// Inicio de la aplicacion mosyrando el tablero
	@GetMapping({"/","/index.html"})
	public String index(Model model) {
		
		Compliance compliance = new Compliance();
		LocalDate fechaLocal = LocalDate.of(2020,10,30);
		
		compliance.setComplianceEvaluationDate(fechaLocal);
		model.addAttribute("complianceForm", compliance);
		
		return "index";
		//return "home";
	}
	
	
	
	@GetMapping({"/login","/login.html"})
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginUser")
	public String logingUser(@Valid @ModelAttribute("userLoginForm")User user, BindingResult result, Model model) {
		
		return "index";
		
	}
	
	
	  @GetMapping({"/home","/home.html"}) public String home() { return "home"; }
	  
	  @GetMapping({"/buttons","/buttons.html"}) public String buttons() { return
	  "buttons"; }
	  
	  @GetMapping({"/cards","/cards.html"}) public String cards() { return "cards";
	  }
	  
	  @GetMapping({"/tables","/tables.html"}) public String tables() { return
	  "tabla"; }
	  
	  @GetMapping({"/catUser","/catUser.html"}) public String catUser() { return
	  "catUser/catUser"; }
	  
	  @GetMapping({"/catUser2","/catUser2.html"}) public String catUser2() { return
	  "catUser/catUser2"; }
	 
	
}


