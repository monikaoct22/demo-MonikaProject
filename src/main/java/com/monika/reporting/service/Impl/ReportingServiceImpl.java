package com.monika.reporting.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monika.jba.entity.Item;
import com.monika.jba.service.impl.ItemServiceImpl;
import com.monika.reporting.service.ReportingService;

/**
 * @author Rohit
 *
 */
@Service
public class ReportingServiceImpl implements ReportingService {

	@Autowired
	private ItemServiceImpl itemService;

	/**
	 * @return
	 */
	public List<Item> getItemList() {
		return itemService.getItems();
	}

}
