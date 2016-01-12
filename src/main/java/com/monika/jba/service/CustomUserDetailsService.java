package com.monika.jba.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Rohit
 *
 */
public interface CustomUserDetailsService {
	
	/**
	 * @param userName
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}
