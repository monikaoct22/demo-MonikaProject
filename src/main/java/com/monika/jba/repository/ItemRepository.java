package com.monika.jba.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.monika.jba.entity.Blog;
import com.monika.jba.entity.Item;

/**
 * @author Monika
 *
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

	/**
	 * @param blog
	 * @return
	 */
	List<Item> findByBlog(Blog blog,Pageable pageable);
}
