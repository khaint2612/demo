package edu.poly.spring.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spring.models.User;
import edu.poly.spring.models.UserDAO;
import edu.poly.spring.services.UserService;

@Controller
@RequestMapping("/backend/user")
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@Autowired
	User _userBean;
	
	@GetMapping("/add")
	public String addOrEdit(ModelMap model) {
		User u = new User();
//		u.setUsername("TaiTD");
		model.addAttribute("USER", u);
		model.addAttribute("ACTION","saveOrUpdate");
		return "backend/user/add";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user) {
//		UserDAO dao = new UserDAO();
//		dao.save(user);
//		System.out.println("size:"+dao.getAll().size());
		UserService.save(user);
		return "backend/user/add";
	}
	
	@RequestMapping("list")
	public String list(ModelMap model, HttpSession session) {
//		UserDAO dao = new UserDAO();
//		model.addAttribute("USERS", dao.getAll());
		if (session.getAttribute("Email") !=null) {
			model.addAttribute("USERS", UserService.findAll());
			return "backend/user/list";	
		}
		return "login";
	}
	@RequestMapping("/edit/{email}")
	public String edit(ModelMap model, 
			@PathVariable(name="email") String email){
//		UserDAO dao = new UserDAO();
//		User u = dao.findByUsername(email);
		Optional<User> u = UserService.findById(email);
		if (u.isPresent()) {
			model.addAttribute("USER", u.get());
		}else {
			model.addAttribute("USER", new User());
		}
		
		model.addAttribute("ACTION","/saveOrUpdate");
		return "backend/user/add";
	}
	
	@RequestMapping("/delete/{email}")
	public String delete(ModelMap model, 
			@PathVariable(name="email") String email){
//		UserDAO dao = new UserDAO();
//		dao.delete(email);
		UserService.deleteById(email);
		model.addAttribute("USERS", UserService.findAll());
		return "backend/user/list";
	}
	//=========================================================
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@PostMapping("checklogin")
	public String checkLogin(ModelMap model ,@RequestParam("email")String email, 
			@RequestParam("password") String password,
			HttpSession session) {
//		if (_userBean.getUsername().equals(email)&& _userBean.getPassword().equals(password)) {
//			System.out.println("Login thanh cong");
//			return "index";
//		}else {
//			System.out.println("Login that bai");
//		}
		
		if (UserService.checkLogin(email, password)) {
			System.out.println("Login thanh cong");
			session.setAttribute("Email", email);
			model.addAttribute("USERS", UserService.findAll());
			return "backend/user/list";
		}else {
			System.out.println("Login that bai");
			model.addAttribute("ERROR", "Email or password not exist");
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("Email");
		return "redirect:/login";
	}
}
