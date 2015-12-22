package com.monika.jba.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.monika.jba.repository.UserRepository2;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	@Autowired
	private UserRepository2 userRepository2;
	
	public void initialize(UniqueUsername constraintAnnotation) {
	
		
	}

	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(userRepository2 == null){
		return true;
		}
		return userRepository2.findByName(username)== null;
	}

}
