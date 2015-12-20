package com.monika.jba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monika.jba.entity.User;
import com.monika.jba.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userservice;
	
	
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
	@RequestMapping
	public String showRegistrer() {
		return "user-register";
	}

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping( method = RequestMethod.POST)
	public String doRegistrer(@Valid @ModelAttribute("user") User user,BindingResult result) {
		if(result.hasErrors()){
			return "user-register";
		}
		userservice.save(user);
		return "redirect:/register.html?success=true";
	}



}
