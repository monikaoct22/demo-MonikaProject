package com.monika.jba.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.monika.jba.service.ItemService;

/**
 * @author Monika
 *
 */
@Controller
public class IndexController {
	private final static Logger logger = Logger.getLogger(IndexController.class);

	/**
	 * @return
	 *
	 * 		Home page of the application will be called from here.
	 * 
	 */
	@Autowired
	private ItemService itemService;

	@RequestMapping("/index")
	public String index(Model model) {
		logger.info("Cal index page of this website.");
		logger.error("This is error log entry");

		model.addAttribute("items", itemService.getItems());
		return "index";
	}
}
