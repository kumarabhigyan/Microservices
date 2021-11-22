package com.olx.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
	@GetMapping(value="/welcome-user")
	public String welcomeUser(Model model) {
		model.addAttribute(("firstName","Tom");
		return "Welcome";
		
		
		
	}
	

}
