package com.monika.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monika.jba.entity.Blog;
import com.monika.jba.entity.User;
import com.monika.jba.repository.BlogRepository;
import com.monika.jba.repository.ItemRepository;
import com.monika.jba.repository.UserRepository2;

@Service
public class Blogservice {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	
	@Autowired
	private UserRepository2 userRepository2;

	public void save(Blog blog, String name) {
		User user=userRepository2.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
	}
	
	@Transactional
	public void delete(Integer id) {
		blogRepository.delete(id);
	}
	

}
