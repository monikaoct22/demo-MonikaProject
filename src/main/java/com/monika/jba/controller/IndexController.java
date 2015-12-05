package com.monika.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Monika
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		System.out.println("call index controller");
		
		return "index";
	}
}
