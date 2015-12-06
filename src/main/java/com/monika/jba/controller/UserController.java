package com.monika.jba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monika.jba.entity.User;
import com.monika.jba.service.UserService;

/**
 * @author Monika
 *
 */
/**
 * @author Rohit
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/users")
	public String users(Model model) {
		List<User> lst = userservice.findAll();

		model.addAttribute("users", lst);
		return "users";
	}

	/**
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id) {
		User user = userservice.findOneWithBlogs(id);

		model.addAttribute("user", user);
		return "user-detail";
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/register")
	public String showRegistrer() {
		return "user-register";
	}
	
	@RequestMapping(value= "/register",method=RequestMethod.POST)
	public String doRegistrer(@ModelAttribute("user") User user) {
		userservice.save(user);
		return "user-register";
	}
	
}
