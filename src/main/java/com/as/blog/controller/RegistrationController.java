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
import com.as.blog.entity.template.Sex;
import com.as.blog.service.UserService;


@Controller
@RequestMapping(value="/registration")
public class RegistrationController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String openRegistrationForm(Model model){
		model.addAttribute(new User());
		return "registration";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(User user, BindingResult bindingResult){

		user.setRegistrationDate(Date.valueOf("2015-03-03"));
		user.setRole(Role.ROLE_ANONYMOUS);
		
//		user.setEnabled((byte)1);

		System.out.println(user);
		
		userService.save(user);
		
		System.out.println(user);
		
		return "registration";
	}
	
}