package com.as.blog.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.entity.Image;
import com.as.blog.service.ArticleImageService;
import com.as.blog.service.ArticleService;

/**
 * @author Andrii 
 * 	Retrieves all articles and images from the Blog database and
 *         provides their in the appropriate Controller.
 */
@Component
public class ArticleProvider {
	
	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleImageService articleImageService;
	
	private Pattern pattern;
	private Matcher matcher;
	
	private final static String ADD_PARAGRAPH = "\n";
	
	private StringBuilder title;
	private StringBuilder image;
	private StringBuilder content;
	private StringBuilder creationDate;
	private StringBuilder wholeArticle;
	private StringBuilder allArticles;
	
	private List<Image> images;
	
	public ArticleProvider() {
		pattern = Pattern.compile(ADD_PARAGRAPH);
		allArticles = new StringBuilder("");
		image = new StringBuilder("");
	}
	
	/**
	 * Retrieves all articles and images from the Blog database 
	 */
	public StringBuilder retrieveArticles() {
		List<Article> articles = articleService.findAll();

		// Sorting the articles in the descending order.
		Collections.sort(articles, new DescendingSortArticle());

		for (Article article : articles) {
			allArticles.append(formArticle(article));
		}
		return allArticles;
	}

	public List<Image> displayImages(Article article) {
		// we find which images the article has !
		List<ArticleImage> articleImages = articleImageService.findByArticle(article);
		List<Image> imageList = null;
		
		if (articleImages.size() != 0) {
			imageList = new LinkedList<Image>();
			
			for (ArticleImage articleImage : articleImages) {
				imageList.add(articleImage.getImage());
			}
		}
		return imageList;
	}

	/**
	 * Adds paragraphs into the article.
	 * @return Article with paragraphs. 
	 */
	private String addParagraph(String article) {
		matcher = pattern.matcher(article);
		
		return matcher.replaceAll("</p><p>");
	}

	private StringBuilder formArticle(Article article) {
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
		content.append(addParagraph(article.getContent()));
		content.append("</p>");

		creationDate = new StringBuilder("<p class='blog-post-meta'>");
		creationDate.append(article.getCreationDate());
		creationDate.append("</p></div><hr>");

		wholeArticle = new StringBuilder(title);
		wholeArticle.append(image);
		wholeArticle.append(content);
		wholeArticle.append(creationDate);

		return wholeArticle;
	}
}
