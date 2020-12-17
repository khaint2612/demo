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

import edu.poly.spring.models.UserAuth;

import edu.poly.spring.services.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	User _userBean;
	
	@GetMapping("/adduser")
	public String addOrEdit(ModelMap model) {
		UserAuth u = new UserAuth();
//		u.setUsername("NamNV");
		model.addAttribute("USER", u);
		model.addAttribute("ACTION", "/saveOrUpdate");
		return "register-user";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") UserAuth username) {
//		UserDAO dao = new UserDAO();
//		dao.save(user);
//		System.out.println("size"+dao.getAll().size());
		userService.save(username);
		return "register-user";
	}
	@RequestMapping("list")
	public String list(ModelMap model,HttpSession session) {
//		UserDAO dao = new UserDAO();
//		model.addAttribute("USERS", dao.getAll());
		if (session.getAttribute("USERNAME") !=null) {
			model.addAttribute("USERS",userService.findAll());
			return "view-user";
		}
		
		return "login";
	}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,
			@PathVariable(name="id") Integer id) {
//		UserDAO dao = new UserDAO();
//		User u = dao.findByUsername(username);

		Optional<UserAuth> u = userService.findById(id);
		if(u.isPresent()) {
			model.addAttribute("USER", u.get());	
		}else {
			model.addAttribute("USER", new UserAuth());
		}
		model.addAttribute("ACTION", "/saveOrUpdate");
		return "register-user";
	}
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,
			@PathVariable(name="id") Integer id) {
//		UserDAO dao = new UserDAO();
//		dao.delete(username);
		userService.deleteById(id);
		model.addAttribute("USERS", userService.findAll());
		
		return "view-user";
	}
	
//	@PostMapping("/checklogin")
//	public String checkLogin(ModelMap model,@RequestParam("username") String username,
//			@RequestParam("password") String password,
//			HttpSession session) {
////		if (_userBean.getUsername().equals(username)&& _userBean.getPassword().equals(password)) {
////			System.out.println("login thành công");
////			return "view-user";
////		}else {
////			System.out.println("login thất bại");
////		}
//		if (userService.checkLogin(username, password)) {
//			System.out.println("login thành công");
//			session.setAttribute("USERNAME", username);
//			model.addAttribute("USERS", userService.findAll());
//			return "view-user";
//		}else {
//			System.out.println("login thất bại");
//			model.addAttribute("ERROR", "Username and password not exist");
//		return "login";
//		}
//	}
//	@GetMapping("logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("USERNAME");
//		return "login";
//	}
}
