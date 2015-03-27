package com.as.blog.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.entity.Image;
import com.as.blog.service.ArticleImageService;
import com.as.blog.service.ArticleService;
import com.as.blog.service.ImageService;
import com.as.blog.util.DescendingSortArticle;


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
	
	@RequestMapping(value="/displayArticles", method=RequestMethod.POST,
					produces = "application/json; charset=utf-8")
	public @ResponseBody StringBuilder displayArticles(){
		StringBuilder allArticles = new StringBuilder();
		
		StringBuilder title;
		StringBuilder image = new StringBuilder("");
		StringBuilder content;
		StringBuilder creationDate;
		
		List<Image> images;
		
		List<Article> articles = articleService.findAll();
		
		// Sorting the articles in the descending order.	
		Collections.sort(articles, new DescendingSortArticle());
		
		
		for (Article article : articles) {
			images = displayImages(article);
			
			title = new StringBuilder("<div  class='row text-justify div-article'><h2>");
			title.append(article.getTitle());
			title.append("</h2>");
			
			if (images != null) {
				
				image = new StringBuilder("<img class='img-rounded img-responsive pull-left image-article' ");
				image.append("src='image_article/");
				
				// TODO set some variable into method get
				image.append(images.get(0).getName());
				image.append("' alt='Responsive image'> ");
			}
			
			content = new StringBuilder("<p>");
			content.append(article.getContent());
			content.append("</p>");
			
			creationDate = new StringBuilder("<p class='blog-post-meta'>");
			creationDate.append(article.getCreationDate());
			creationDate.append("</p></div><hr>");
			
			allArticles.append(title);
			allArticles.append(image);
			allArticles.append(content);
			allArticles.append(creationDate);
			
		}
		
		return allArticles;
	}
	
	public List<Image> displayImages(Article article){
		// we find which images the article has !   
		List<ArticleImage> articleImages = articleImageService.findByArticle(article);

		List<Image> images = null;
		Image image;
		
		for (ArticleImage articleImage : articleImages) {
			images = new LinkedList<Image>();
			image = articleImage.getImage();
			images.add(image);
		}
		return images;
	}

}
