package com.as.blog.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.entity.Image;
import com.as.blog.service.ArticleImageService;
import com.as.blog.service.ArticleService;
import com.as.blog.service.ImageService;


@Controller
@RequestMapping(value="/")
public class IndexController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ArticleImageService articleImageService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showMainPage() {
		return "index";
	}
	
	@RequestMapping(value="/showArticles", method=RequestMethod.GET)
	public @ResponseBody List<Article> showArticles(){
		List<Article> articles = articleService.findAll();

// Test !
		
		
		return articles;
	}
	
	@RequestMapping(value="/showImages", method=RequestMethod.POST)
	public @ResponseBody List<Image> showImages(Article article){
		
		// we find which images the article has !   
		List<ArticleImage> articleImages = articleImageService.findByArticle(article);
		
		List<Image> images = null;
		
		for (ArticleImage articleImage : articleImages) {
			
			images = new LinkedList<Image>();
			
			Image image = articleImage.getImage();
			
			images.add(image);
			
			System.out.println("############# " + article.getTitle() + " " + image.getName());
		}
		
		return images;
	}

}
