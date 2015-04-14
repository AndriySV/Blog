package com.as.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/userProfile")
public class UserProfileController {
	
	@RequestMapping
	public String openPage() {
		return "userProfile";
	}

}
