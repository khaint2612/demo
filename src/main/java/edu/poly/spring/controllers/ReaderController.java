package edu.poly.spring.controllers;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spring.dtos.ReaderDto;
import edu.poly.spring.models.Reader;
import edu.poly.spring.models.Staffs;

import edu.poly.spring.services.ReaderService;

@Controller
@RequestMapping("/backend/reader")
public class ReaderController {
	@Autowired
	private ReaderService readerService;

	
	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("reader", readerService.findAll());
		return "backend/reader/list";
	}
	@GetMapping("/add")
	public String add(ModelMap model) {
		
		
		Reader reader = new Reader();
		model.addAttribute("reader", reader);
		
		return "backend/reader/addOrEdit"; 
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(Model model, Reader reader) {
			
		readerService.save(reader);
		
		model.addAttribute("reader", reader);
		return "backend/reader/addOrEdit";
	
	}
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Reader> optStaff = readerService.findById(id);
		if (optStaff.isPresent()) {
			model.addAttribute("reader",optStaff.get());
		} else {
			return list(model);

		}
		
		return "backend/reader/addOrEdit"; 
	}
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name = "id") String id) {
		readerService.deleteById(id);
		
		return list(model);
	}
	@GetMapping("/find")
	public String find(ModelMap model,@RequestParam(defaultValue = "") String name) {
		List<Reader> list = readerService.findByNameLikeOrderByName(name);
		
		model.addAttribute("reader",list);
		return "backend/reader/find";
		
	}
	@ModelAttribute(name = "staff")
	public List<Staffs> getStaff(){
		return readerService.findAllStaff();
	}
}
