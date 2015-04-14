package com.as.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/forum")
public class ForumController {
	
	@RequestMapping
	public String openPage() {
		return "forum";
	}

}
