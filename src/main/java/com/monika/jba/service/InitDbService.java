package com.monika.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private UserRepository2 userRepository;

	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_ADMIN");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_USER");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setEmail("admin@gmail.com");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);

		Blog myBlog = new Blog();
		myBlog.setName("Monika Blog");
		myBlog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		myBlog.setUser(userAdmin);
		blogRepository.save(myBlog);

		Item item1 = new Item();
		item1.setBlog(myBlog);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);

		Item item2 = new Item();
		item2.setBlog(myBlog);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);

	}
}
