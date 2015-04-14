package com.as.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/music")
public class MusicController {
	
	@RequestMapping
	public String openPage() {
		return "music";
	}

}
