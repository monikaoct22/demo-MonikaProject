package com.monika.jba.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Monika
 *
 */
@Controller
public class LoginController {
	private final static Logger logger = Logger.getLogger(LoginController.class);
	
	/**
	 * @return
	 * Login page of the application.
	 */
	@RequestMapping("/login")
	public String login() {

		return "login";
	}
}
