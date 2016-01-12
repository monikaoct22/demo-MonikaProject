package com.monika.jba.service;

import java.util.List;

import com.monika.jba.entity.Item;

/**
 * @author Rohit
 *
 */
public interface ItemService {

	/**
	 * @param item
	 * @param id
	 */
	public void save(Item item, Integer id);

	/**
	 * @return
	 */
	public List<Item> getItems();

}
