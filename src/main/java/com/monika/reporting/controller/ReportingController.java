package com.monika.reporting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.monika.jba.entity.Item;
import com.monika.reporting.service.Impl.ReportingServiceImpl;

/**
 * @author Rohit
 *
 */
@Controller
public class ReportingController {

	@Autowired
	protected ReportingServiceImpl reportingService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/ItemsExport", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		
		System.out.println("inside export method");
		List<Item> itemList = reportingService.getItemList();
		return new ModelAndView("itemListExcel", "itemList", itemList);
	}
}