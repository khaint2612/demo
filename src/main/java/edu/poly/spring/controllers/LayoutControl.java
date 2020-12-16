package edu.poly.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backend/fragments/")
public class LayoutControl {
	@GetMapping("/index")
	public String index() {
		return "fragments/index";
	}
}
