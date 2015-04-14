package com.as.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Андрій
 * Processes data from login.jsp
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {

	/**
	 * @return the value which redirects to the page login.jsp 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String loginUser (@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model){
		
		return "login";
	}
	
}
