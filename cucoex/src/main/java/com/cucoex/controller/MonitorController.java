package com.cucoex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cucoex.entity.Company;

@Controller
public class MonitorController {

	
	public MonitorController() {

	}
	
	// Ejecuta el monitor
			@GetMapping({"/runMonitor"})
			public String getRunMonitor(Model model) {
				
				// Actualizar un compliance para una jerarquia especifica - Company,ImpExtType, Causal
				return "runMonitor";
			}

}
