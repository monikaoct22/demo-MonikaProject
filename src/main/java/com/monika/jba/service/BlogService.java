package com.monika.jba.service;

import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;

import com.monika.jba.entity.Blog;

/**
 * @author Rohit
 *
 */
public interface BlogService {

	/**
	 * @param blog
	 * @param name
	 */
	public void save(Blog blog, String name);

	/**
	 * @param blog
	 */
	@PreAuthorize("#blog.user.name==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog);

	/**
	 * @param id
	 * @return
	 */
	public Blog findOne(int id);
}
