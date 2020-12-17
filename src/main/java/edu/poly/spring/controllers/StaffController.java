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

import edu.poly.spring.models.Staff;
import edu.poly.spring.services.StaffService;

@Controller
@RequestMapping("/backend/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("staff", new Staff());
		return "backend/staff/addOrEdit";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,Staff staff) {
		staffService.save(staff);
		model.addAttribute(staff);
		return "backend/staff/addOrEdit";
		
		
	}
	@GetMapping("/edit/{staffId}")
	public String edit(ModelMap model, @PathVariable(name = "staffId") String staffId) {
		Optional<Staff> optStaff = staffService.findById(staffId);
		if (optStaff.isPresent()) {
			model.addAttribute("staff",optStaff.get());
		} else {
			return list(model);

		}
		
		return "backend/staff/addOrEdit"; 
	}
	@GetMapping("/delete/{staffId}")
	public String delete(ModelMap model,@PathVariable(name = "staffId") String staffId) {
		staffService.deleteById(staffId);
		
		return list(model);
	}
	@GetMapping("/list")
	public String list(ModelMap model) {
		List<Staff> list = (List<Staff>) staffService.findAll();
		model.addAttribute("staff", list);
		return "backend/staff/list";
	}
	@GetMapping("/find")
	public String find(ModelMap model,@RequestParam(defaultValue = "") String name) {
		List<Staff> list = staffService.findByNameLikeOrderByName(name);
		
		model.addAttribute("staff",list);
		return "backend/staff/find";
		
	}
}
