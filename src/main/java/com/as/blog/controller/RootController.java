package com.as.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class RootController {

	@RequestMapping
	public String root() {
		return "index";
	}
	
}
