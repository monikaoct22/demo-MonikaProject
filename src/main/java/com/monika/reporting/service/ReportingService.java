package com.monika.reporting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monika.jba.entity.Item;
import com.monika.jba.service.ItemService;

/**
 * @author Rohit
 *
 */
@Service
public class ReportingService {

	@Autowired
	private ItemService itemService;

	/**
	 * @return
	 */
	public List<Item> getItemList() {
		return itemService.getItems();
	}

}
