package com.monika.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monika.jba.entity.Role;
import com.monika.jba.entity.User;
import com.monika.jba.repository.UserRepository2;

/**
 * @author Rohit
 * 
 *         This class is not in use for now. But can be used in spring security
 *         to get the user and role information from repository class.
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository2 userRepository2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 * 
	 * 
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository2.findByName(userName);
		System.out.println(user.getName());

		List<Role> roles = user.getRoles();
		Role role = roles.get(0);
		System.out.println(role.getName());

		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				getGrantedAuthorities(user));

	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<Role> roles = user.getRoles();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : roles) {
			System.out.println("Role Name : " + role.getName());
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

}
