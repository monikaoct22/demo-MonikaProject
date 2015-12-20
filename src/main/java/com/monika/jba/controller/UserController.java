package com.monika.jba.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.mustachejava.Binding;
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
	 * @return
	 */
	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
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
		return "account";
	}

	/**
	 * @param blog
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog,BindingResult result, Principal principal) {
		if(result.hasErrors()){
			return showRegistrer(model,principal);
		}
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

	
}