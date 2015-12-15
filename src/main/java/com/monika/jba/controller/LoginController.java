package com.monika.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Monika
 *
 */
@Controller
public class LoginController {
	
	
	/**
	 * @return
	 * Login page of the application.
	 */
	@RequestMapping("/login")
	public String login() {

		return "login";
	}
}
