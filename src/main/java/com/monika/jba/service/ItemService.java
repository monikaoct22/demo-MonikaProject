package com.monika.jba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.monika.jba.entity.Blog;
import com.monika.jba.entity.Item;
import com.monika.jba.repository.BlogRepository;
import com.monika.jba.repository.ItemRepository;

/**
 * @author Monika
 *
 */
@Service
public class ItemService {

	private static final Direction Direction = null;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * @param item
	 * @param id
	 */
	public void save(Item item, Integer id) {
		Blog blog = blogRepository.findById(id);
		item.setBlog(blog);
		itemRepository.save(item);
	}

	public List<Item> getItems() {
		return itemRepository.findAll(new PageRequest(0, 20, Direction.DESC, "publishedDate")).getContent();
	}
}
