package com.monika.jba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.monika.jba.entity.Blog;
import com.monika.jba.entity.User;
import com.monika.jba.repository.BlogRepository;
import com.monika.jba.repository.UserRepository2;
import com.monika.jba.service.BlogService;

/**
 * @author Monika
 *
 */
@Service
public class BlogserviceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository2 userRepository2;

	/**
	 * @param blog
	 * @param name
	 */
	public void save(Blog blog, String name) {
		User user = userRepository2.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}

	/**
	 * @param blog
	 */
	//@PreAuthorize("#blog.user.name==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}

	/**
	 * @param id
	 * @return
	 */
	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

}
