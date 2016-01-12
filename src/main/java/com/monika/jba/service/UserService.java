package com.monika.jba.service;

import java.util.List;
import com.monika.jba.entity.User;

/**
 * @author Monika
 *
 */
public interface UserService {

	/**
	 * @return
	 */
	public List<User> findAll();

	/**
	 * @param id
	 * @return
	 */
	public User findOne(int id);

	/**
	 * @param id
	 * @return
	 */
	public User findOneWithBlogs(int id);

	/**
	 * @param user
	 */
	public void save(User user);

	/**
	 * @param name
	 * @return
	 */
	public User findOneWithBlogs(String name);

	/**
	 * @param id
	 */
	public void delete(int id);

	/**
	 * @param username
	 * @return
	 */
	public User findOne(String username);
}
