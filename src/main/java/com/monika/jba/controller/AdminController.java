
package com.monika.jba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monika.jba.entity.User;
import com.monika.jba.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	private UserService userservice;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping
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
	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id) {
		User user = userservice.findOneWithBlogs(id);

		model.addAttribute("user", user);
		return "user-detail";
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userservice.delete(id);
		return "users";

	}


}
