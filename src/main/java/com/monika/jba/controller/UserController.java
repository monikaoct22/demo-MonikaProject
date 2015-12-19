package com.monika.jba.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monika.jba.entity.Blog;
import com.monika.jba.entity.User;
import com.monika.jba.service.Blogservice;
import com.monika.jba.service.UserService;

/**
 * @author Monika
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userservice;

	@Autowired
	private Blogservice blogservice;

	/**
	 * @return To get the user object from JSP page.
	 */
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	/**
	 * @return
	 */
	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
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

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegistrer(@ModelAttribute("user") User user) {
		userservice.save(user);
		return "redirect:/register.html?success=true";
	}

	/**
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping("/account")
	public String showRegistrer(Model model, Principal principal) {
		String name = principal.getName();
		
		User user = userservice.findOneWithBlogs(name);
		model.addAttribute("user", user);
		//String str = "redirect:/users/" + user.getId() + ".html"; 
		return "user-detail";
	}

	/**
	 * @param blog
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal) {
		String name = principal.getName();
		blogservice.save(blog, name);
		return "redirect:/account.html";
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/account/{id}")
	public String removeBlog(@PathVariable int id) {
		Blog blog=blogservice.findOne(id);
		blogservice.delete(blog);
		return "redirect:/account.html";
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/users/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userservice.delete(id);
		return "users";

	}
}