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

import edu.poly.spring.models.PublishingCompany;
import edu.poly.spring.services.PublishingCompanyService;

@Controller
@RequestMapping("/backend/publishingCompany")
public class PublishingCompanyControl {
	@Autowired
	private PublishingCompanyService publishingCompanyService;

	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("publishingCompany", new PublishingCompany());
		return "backend/publishingCompany/add";
	}

	@PostMapping("/save")
	public String save(ModelMap model, PublishingCompany publishingCompany) {
		publishingCompanyService.save(publishingCompany);
		model.addAttribute(publishingCompany);
		return list(model);
	}

	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<PublishingCompany> opt = publishingCompanyService.findById(id);
		if (opt.isPresent()) {
			model.addAttribute("publishingCompany", opt.get());
		} else {
			return list(model);
		}
		return "backend/publishingCompany/edit";
	}

	@PostMapping("/update")
	public String update(PublishingCompany publishingCompany, ModelMap model) {
		publishingCompanyService.save(publishingCompany);
		model.addAttribute(publishingCompany);
		return "backend/publishingCompany/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		publishingCompanyService.deleteById(id);
		return list(model);
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<PublishingCompany> list = (List<PublishingCompany>) publishingCompanyService.findAll();
		model.addAttribute("publishingCompanies", list);
		return "backend/publishingCompany/list";
	}

	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		List<PublishingCompany> list = publishingCompanyService.findByNameLikeOrderByName(name);
		model.addAttribute("publishingCompanies", list);
		return "backend/publishingCompany/find";
	}
}
