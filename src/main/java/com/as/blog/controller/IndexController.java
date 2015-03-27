package com.as.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.as.blog.util.ArticleProvider;

@Controller
@RequestMapping(value="/")
public class IndexController {

	@Autowired
	private ArticleProvider articleProvider; 
	
	@RequestMapping(method=RequestMethod.GET)
	public String showMainPage() {
		return "index";
	}
	
	@RequestMapping(value="/displayArticles", method=RequestMethod.POST,
					produces = "application/json; charset=utf-8")
	public @ResponseBody StringBuilder displayArticles(){
		
		return articleProvider.retrieveArticles();
	}

}
