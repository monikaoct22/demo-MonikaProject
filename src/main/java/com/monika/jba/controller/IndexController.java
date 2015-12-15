package com.monika.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Monika
 *
 */
@Controller
public class IndexController {

	/**
	 * @return
	 *
	 * 		Home page of the application will be called from here.
	 */
	@RequestMapping("/index")
	public String index() {

		return "index";
	}
}
