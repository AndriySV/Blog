package com.as.blog.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String test(){

		User user = new User();
		
		user.setName("Andrii");
		user.setEmail("a@gmail");
		user.setPassword("andrii");
		user.setSex(Sex.MALE);
		user.setBirthday(Date.valueOf("1995-03-15"));
		user.setRegistrationDate(Date.valueOf("2015-03-03"));
		user.setRole(Role.ROLE_ADMIN);
		user.setEnabled((byte)1);

		userService.save(user);
		
		return "registration";
	}
	
}