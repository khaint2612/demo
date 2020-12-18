package edu.poly.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutControl {
	@GetMapping("/backend/fragments//index")
	public String index() {
		return "fragments/index";
	}
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
}
