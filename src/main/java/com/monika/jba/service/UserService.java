package com.monika.jba.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.monika.jba.entity.Blog;
import com.monika.jba.entity.Item;
import com.monika.jba.entity.Role;
import com.monika.jba.entity.User;
import com.monika.jba.repository.BlogRepository;
import com.monika.jba.repository.ItemRepository;
import com.monika.jba.repository.RoleRepository;
import com.monika.jba.repository.UserRepository2;

/**
 * @author Monika
 *
 */
@Service
// @Transactional
public class UserService {

	@Autowired
	private UserRepository2 userRepository2;
	@Autowired
	private BlogRepository blogRepository2;
	@Autowired
	private ItemRepository itemRepository2;

	@Autowired
	private RoleRepository roleRepository;

	public java.util.List<User> findAll() {
		return userRepository2.findAll();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository2.findOne(id);
	}

	/**
	 * @param id
	 * @return
	 */
	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);

		List<Blog> blogs = blogRepository2.findByUser(user);
		// List<Blog> blogs1 = blogRepository2.findByUserID();

		for (Blog blog : blogs) {
			List<Item> items = itemRepository2.findByBlog(blog,
					new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);

		return user;
	}

	/**
	 * @param user
	 * 
	 *            Saving the user with default role ROLE_USER and his password
	 *            will be BCrypt.
	 */
	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository2.save(user);
	}

}
