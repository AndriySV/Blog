package com.as.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.as.blog.util.ArticleProvider;

/**
 * @author Андрій
 * Processes data from index.jsp
 */
@Controller
@RequestMapping(value="/")
public class IndexController {

	@Autowired
	private ArticleProvider articleProvider; 
	
	/**
	 * * @return the value which redirects to the page index.jsp 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String showMainPage() {
		return "index";
	}
	
	/**
	 * Displays all articles on the index page.
	 */
	@RequestMapping(value="/displayArticles", method=RequestMethod.POST,
					produces = "application/json; charset=utf-8")
	public @ResponseBody StringBuilder displayArticles(){
		
		return articleProvider.retrieveArticles();
	}

}
