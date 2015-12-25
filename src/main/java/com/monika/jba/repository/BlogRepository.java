package com.monika.jba.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monika.jba.entity.Blog;
import com.monika.jba.entity.User;

/**
 * @author Monika
 *
 */
@Resource
public interface BlogRepository extends JpaRepository<Blog, Integer> {

	/**
	 * @param user
	 * @return
	 */
	public List<Blog> findByUser(User user);

	public Blog findById(Blog blog);

	public Blog findById(Integer id);
		
	/**
	 * @return
	 */
	/*
	 * @Query(nativeQuery = true, value = "select * from blog where user_id= 3 "
	 * ) public List<Blog> findByUserID();
	 */
}
