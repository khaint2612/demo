package edu.poly.spring.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.spring.dtos.StaffDTO;
import edu.poly.spring.models.Staffs;
import edu.poly.spring.services.StaffService;


@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		StaffDTO staff = new StaffDTO();
		model.addAttribute("STAFFDTO", staff);
		model.addAttribute("ACTION" , "/staff/saveOrUpdate");
		return "backend/staff/addOrEdit";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model , @ModelAttribute("STAFFDTO") StaffDTO dto) {
		Optional<Staffs> optionalStaff = staffService.findById(dto.getId());
		Staffs staff = null;
		String image = "Logo.png";
		Path path = Paths.get("uploads/");
		if (optionalStaff.isPresent()) {
		//	save
			if (dto.getPhoto().isEmpty()) {
				image = optionalStaff.get().getPhoto();
			}else {
				try {
					InputStream inputStream = dto.getPhoto().getInputStream();
					Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
					image = dto.getPhoto().getOriginalFilename().toString();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		}
		}else {
			// add new 
			if (!dto.getPhoto().isEmpty()) {
				try {
					InputStream inputStream = dto.getPhoto().getInputStream();
					Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
					image = dto.getPhoto().getOriginalFilename().toString();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		}
	}
		staff = new Staffs(dto.getId(), dto.getName(), dto.getIdcard(), dto.isGender(),image,dto.getAddress(),dto.getPhone(),dto.getEmail());
		staffService.save(staff);
		return "backend/staff/addOrEdit";
	}
		
		
		
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Staffs> opStaff = staffService.findById(id);
		StaffDTO dto = null;
		if (opStaff.isPresent()) {
			Staffs st = opStaff.get();
			File file = new File("uploads/" + st.getPhoto());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multiphoto = new MockMultipartFile("file", file.getName(),"text/plain",
						IOUtils.toByteArray(input));
				dto = new StaffDTO(st.getId(), st.getName(), st.isGender(), st.getIdcard(),multiphoto,
						st.getEmail(),st.getPhone(),st.getAddress());
				
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			model.addAttribute("STAFFDTO",dto);
			
		}else {
			model.addAttribute("STAFFDTO", new StaffDTO());
		}
		model.addAttribute("ACTION" , "/staff/saveOrUpdate");
		return "backend/staff/addOrEdit"; 
	}
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name = "id") String id) {
		staffService.deleteById(id);
		
		return list(model);
	}
	@GetMapping("/list")
	public String list(ModelMap model) {
		List<Staffs> list = (List<Staffs>) staffService.findAll();
		model.addAttribute("staff", list);
		return "backend/staff/list";
	}
	@GetMapping("/find")
	public String find(ModelMap model,@RequestParam(defaultValue = "") String name) {
		List<Staffs> list = staffService.findByNameLikeOrderByName(name);
		
		model.addAttribute("staff",list);
		return "backend/staff/find";
		
	}
}
