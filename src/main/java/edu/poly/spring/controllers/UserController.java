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
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@Autowired
	User _userBean;
	
	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		User u = new User();
//		u.setUsername("TaiTD");
		model.addAttribute("USER", u);
		model.addAttribute("ACTION","saveOrUpdate");
		return "register-user";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user) {
//		UserDAO dao = new UserDAO();
//		dao.save(user);
//		System.out.println("size:"+dao.getAll().size());
		UserService.save(user);
		return "register-user";
	}
	
	@RequestMapping("list")
	public String list(ModelMap model, HttpSession session) {
//		UserDAO dao = new UserDAO();
//		model.addAttribute("USERS", dao.getAll());
		if (session.getAttribute("USERNAME") !=null) {
			model.addAttribute("USERS", UserService.findAll());
			return "view-user";	
		}
		return "login";
	}
	@RequestMapping("/edit/{username}")
	public String edit(ModelMap model, 
			@PathVariable(name="username") String username){
//		UserDAO dao = new UserDAO();
//		User u = dao.findByUsername(username);
		Optional<User> u = UserService.findById(username);
		if (u.isPresent()) {
			model.addAttribute("USER", u.get());
		}else {
			model.addAttribute("USER", new User());
		}
		
		model.addAttribute("ACTION","/saveOrUpdate");
		return "register-user";
	}
	
	@RequestMapping("/delete/{username}")
	public String delete(ModelMap model, 
			@PathVariable(name="username") String username){
//		UserDAO dao = new UserDAO();
//		dao.delete(username);
		UserService.deleteById(username);
		model.addAttribute("USERS", UserService.findAll());
		return "view-user";
	}
	//=========================================================
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@PostMapping("checklogin")
	public String checkLogin(ModelMap model ,@RequestParam("username")String username, 
			@RequestParam("password") String password,
			HttpSession session) {
//		if (_userBean.getUsername().equals(username)&& _userBean.getPassword().equals(password)) {
//			System.out.println("Login thanh cong");
//			return "index";
//		}else {
//			System.out.println("Login that bai");
//		}
		
		if (UserService.checkLogin(username, password)) {
			System.out.println("Login thanh cong");
			session.setAttribute("USERNAME", username);
			model.addAttribute("USERS", UserService.findAll());
			return "view-user";
		}else {
			System.out.println("Login that bai");
			model.addAttribute("ERROR", "Username or password not exist");
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USERNAME");
		return "redirect:/login";
	}
}
