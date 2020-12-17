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

import edu.poly.spring.models.Reader;
import edu.poly.spring.models.Staff;

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
//		if (result.hasErrors()) {
//			model.addAttribute("message", "Please input all required fields!!");
//			model.addAttribute("readerDto", reader);
//			return "backend/reader/addOrEdit"; 
//		}
//
//		Path path = Paths.get("images/");
//		try(InputStream inputStream = reader.getImage().getInputStream()){
//			Files.copy(inputStream, path.resolve(reader.getImage().getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//			String filename= reader.getImage().getOriginalFilename();
//		}catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("message", "Error: "+ e.getMessage());
//		}
		readerService.save(reader);
//		Reader readers = new Reader();
//		readers.setName(reader.getName());
//		readers.setReaderId(reader.getReaderId());
//		reader.setGender(reader.getGender());
//		readers.setPhoto(reader.getImage().getOriginalFilename());
//		readers.setBirthday(reader.getBirthday());
//		reader.setEmail(reader.getEmail());
//		reader.setAddress(reader.getAddress());
//		
//		Staff staff = new Staff();
//		staff.setStaffId(reader.getStaffId());
//		readers.setStaff(staff);
//		
//		readerService.save(readers);
		
		model.addAttribute("reader", reader);
		return "backend/reader/addOrEdit";
	
	}
	@GetMapping("/edit/{readerId}")
	public String edit(ModelMap model, @PathVariable(name = "readerId") String readerId) {
		Optional<Reader> optStaff = readerService.findById(readerId);
		if (optStaff.isPresent()) {
			model.addAttribute("reader",optStaff.get());
		} else {
			return list(model);

		}
		
		return "backend/reader/addOrEdit"; 
	}
	@GetMapping("/delete/{readerId}")
	public String delete(ModelMap model,@PathVariable(name = "readerId") String readerId) {
		readerService.deleteById(readerId);
		
		return list(model);
	}
	@GetMapping("/find")
	public String find(ModelMap model,@RequestParam(defaultValue = "") String name) {
		List<Reader> list = readerService.findByNameLikeOrderByName(name);
		
		model.addAttribute("reader",list);
		return "backend/reader/find";
		
	}
	@ModelAttribute(name = "staff")
	public List<Staff> getStaff(){
		return readerService.findAllStaff();
	}
}
