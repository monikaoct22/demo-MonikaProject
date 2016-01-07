package com.monika.jba.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.monika.jba.entity.User;
import com.monika.jba.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private final static Logger logger = Logger.getLogger(RegisterController.class);

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
	@RequestMapping(method = RequestMethod.POST)
	public String doRegistrer(@Valid @ModelAttribute("user") User user, BindingResult result,RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userservice.save(user);
		redirectAttributes.addFlashAttribute("success", true);
		return "redirect:/register.html";
	}
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userservice.findOne(username) == null;
		return available.toString();
	}

}
