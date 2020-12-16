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

import edu.poly.spring.models.Category;
import edu.poly.spring.services.CategoryService;

@Controller
@RequestMapping("/backend/category")
public class CategoryControl {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("category", new Category());
		return "backend/category/add";
	}

	@PostMapping("/save")
	public String save(ModelMap model, Category category) {
		categoryService.save(category);
		model.addAttribute(category);
		return list(model);
	}

	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Category> opt = categoryService.findById(id);
		if (opt.isPresent()) {
			model.addAttribute("category", opt.get());
		} else {
			return list(model);
		}
		return "backend/category/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		categoryService.deleteById(id);
		return list(model);
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<Category> list = (List<Category>) categoryService.findAll();
		model.addAttribute("categories", list);
		return "backend/category/list";
	}

	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		List<Category> list = categoryService.findByNameLikeOrderByName(name);
		model.addAttribute("categories", list);
		return "backend/category/find";
	}
}
