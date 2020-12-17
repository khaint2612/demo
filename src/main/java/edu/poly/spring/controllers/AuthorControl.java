package edu.poly.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spring.models.Author;
import edu.poly.spring.services.AuthorService;

@Controller
@RequestMapping("/backend/author")
public class AuthorControl {
	@Autowired
	private AuthorService authorService;

	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("author", new Author());
		return "backend/author/add";
	}
	
	@PostMapping("/save")
	public String save(ModelMap model, Author author) {
		authorService.save(author);
		model.addAttribute(author);
		return list(model);
	}

	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Author> opt = authorService.findById(id);
		if (opt.isPresent()) {
			model.addAttribute("author", opt.get());
		} else {
			return list(model);
		}
		return "backend/author/edit";
	}

	@PostMapping("/update")
	public String update(Author author, ModelMap model) {
		authorService.save(author);
		model.addAttribute(author);
		return "backend/author/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		authorService.deleteById(id);
		return list(model);
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<Author> list = (List<Author>) authorService.findAll();
		model.addAttribute("authors", list);
		return "backend/author/list";
	}

	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		List<Author> list = authorService.findByNameLikeOrderByName(name);
		model.addAttribute("authors", list);
		return "backend/author/find";
	}
}
