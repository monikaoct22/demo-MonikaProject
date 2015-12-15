package com.monika.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monika.jba.entity.Role;

/**
 * @author Monika
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
