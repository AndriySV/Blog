package com.as.blog.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.as.blog.entity.User;
import com.as.blog.service.UserService;

/**
 * Validates user's name and email
 * @author Андрій
 *
 */
@Component
public class RegistrationValidator implements Validator  {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	/**
	 * Validates whether there are given name or email in the table User
	 */
	@Override
	public void validate(Object object, Errors errors) {

		User currentUser = (User) object;
		
		List<User> users = userService.findByNameOrEmail(currentUser.getName(), currentUser.getEmail());
		
		for (User registredUser : users) {
			
			if (currentUser.getName().equalsIgnoreCase(registredUser.getName())) {
				errors.rejectValue("name", "error_name", "Помилка. Дане ім'я уже використовується !");
			}
			if (currentUser.getEmail().equalsIgnoreCase(registredUser.getEmail())) {
				errors.rejectValue("email", "error_email", "Помилка. Даний email уже використовується !");
			}
		}
		
	}

}
