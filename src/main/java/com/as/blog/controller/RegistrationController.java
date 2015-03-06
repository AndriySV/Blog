package com.as.blog.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.as.blog.entity.User;
import com.as.blog.entity.template.Role;
import com.as.blog.service.UserService;
import com.as.blog.util.PasswordEncoder;
import com.as.blog.util.RegistrationValidator;


@Controller
@RequestMapping(value="/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistrationValidator registrationValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String openRegistrationForm(Model model){
		model.addAttribute(new User());
		return "registration";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(User user, BindingResult bindingResult){

		registrationValidator.validate(user, bindingResult);
		
		if (!bindingResult.hasErrors()) {
			
			String hashedPasword = PasswordEncoder.encode(user.getPassword());
			user.setPassword(hashedPasword);
			
			Date currentDate = new Date(new java.util.Date().getTime());
			user.setRegistrationDate(currentDate);
			
			user.setRole(Role.ROLE_USER);
		
			userService.save(user);
			
			return "redirect:/";
		} else {
			return "registration";
		}
	}
	
	
	
}