package edu.poly.spring.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.spring.models.Library;
import edu.poly.spring.services.LibraryService;



@Controller
@RequestMapping("library")
public class LibraryController {
	@Autowired
	private LibraryService  libraryService;
	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("library", new Library());
		return"library/addOrEdit";		
	} 
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, Library library) {
		libraryService.save(library);
		
		model.addAttribute(library);
		
		return"library/addOrEdit";
		 
	
		
	}
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model,
			@PathVariable(name="id") String id) {

		Optional<Library> de = libraryService.findById(id);
		if(de.isPresent()) {
			model.addAttribute("library", de.get());	
		}else {
			model.addAttribute("library", new Library());
		}
		model.addAttribute("ACTION" , "/library/saveOrUpdate");
		return "library/addOrEdit";
	}
	@RequestMapping("/delete/{id}")
	public String deleteLBR(ModelMap model,
			@PathVariable(name="id") String id) {
		libraryService.deleteById(id);
		model.addAttribute("LIBRARY", libraryService.findAll());
		return "library/list";
	}
	@RequestMapping("/list")
	public String list(ModelMap model,HttpSession session) {
//		if(session.getAttribute("USERNAME") != null) {
			model.addAttribute("LIBRARY",libraryService.findAll());
			return "library/list";
		}
//		return "login";
//	
//	}
	@RequestMapping("/find")
	public String find() {
		return"find";
	}
	
}
