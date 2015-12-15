package com.monika.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.monika.jba.entity.User;

/**
 * @author Monika
 *
 */
public interface UserRepository2 extends JpaRepository<User, Integer> {

	/**
	 * @param userName
	 * @return
	 * This is not in use but can get called from spring security
	 */
	@Query(nativeQuery = true, value = "select * from user where name= ? ")
	public User findByName(String userName);
}
