package com.as.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/motivation")
public class MotivationController {

	@RequestMapping
	public String openPage() {
		return "motivation";
	}
	
}
