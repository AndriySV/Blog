package com.as.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.as.blog.entity.Article;
import com.as.blog.service.ArticleService;


@Controller
@RequestMapping(value="/")
public class IndexController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showMainPage() {
		return "index";
	}
	
	@RequestMapping(value="/showArticles", method=RequestMethod.GET)
	public @ResponseBody List<Article> showArticles(){
		List<Article> articles = articleService.findAll();
		
		return articles;
	}

}
