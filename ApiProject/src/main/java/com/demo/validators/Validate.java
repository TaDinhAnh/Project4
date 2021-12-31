package com.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class Validate implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Validate.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}