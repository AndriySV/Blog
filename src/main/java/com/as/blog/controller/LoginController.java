package com.as.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public String loginUser (@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model){
		
		/*if (error != null) {
			model.addAttribute("error", "Invalid email or password!");
		}*/
		return "login";
	}
	
}
