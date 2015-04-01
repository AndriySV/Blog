package com.as.blog.util;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.service.ArticleImageService;
import com.as.blog.service.ArticleService;

/**
 * @author Andrii Retrieves all articles and images from the Blog database and
 *         provides their in the appropriate Controller.
 */
@Component
public class ArticleProvider {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleImageService articleImageService;

	private Pattern patternNewLine;
	
	private Pattern patternNewParagraph;
	
	private Matcher matcherNewLine;
	private Matcher matcherNewParagraph;
	
	private final static String NEW_LINE = "\n";
	private final static String NEW_PARAGRAPH = "<p>";
	
	private StringBuilder titleHTML;
	private StringBuilder imageHTML;
	private StringBuilder contentHTML;
	private StringBuilder creationDateHTML;
	private StringBuilder articleHTML;
	private StringBuilder allArticlesHTML;

	public ArticleProvider() {
		patternNewLine = Pattern.compile(NEW_LINE);
		patternNewParagraph = Pattern.compile(NEW_PARAGRAPH);
	}

	/**
	 * Retrieves all articles and images from the Blog database
	 */
	public StringBuilder retrieveArticles() {
		allArticlesHTML = new StringBuilder("");
		List<Article> articles = articleService.findAll();

		// Sorting the articles in the descending order.
		Collections.sort(articles, new DescendingSortArticle());

		for (Article article : articles) {
			allArticlesHTML.append(formArticle(article));
		}
		return allArticlesHTML;
	}

	private StringBuilder formArticle(Article article) {
		titleHTML = new StringBuilder("<div  class='row text-justify div-article'><h2>");
		titleHTML.append(article.getTitle());
		titleHTML.append("</h2>");

		contentHTML = new StringBuilder("<div class='row div-paragraph'><p>");
		contentHTML.append(addDivParagraph(article.getContent()));
		contentHTML.append("</p></div>");

		addImage(article);

		creationDateHTML = new StringBuilder("<p class='blog-post-meta'>");
		creationDateHTML.append(article.getCreationDate());
		creationDateHTML.append("</p></div><hr>");

		articleHTML = new StringBuilder(titleHTML);
		articleHTML.append(contentHTML);
		articleHTML.append(creationDateHTML);

		return articleHTML;
	}
	
	/**
	 * Adds paragraphs into the article.
	 * 
	 * @return Article with paragraphs.
	 */
	private String addDivParagraph(String articleText) {
		matcherNewLine = patternNewLine.matcher(articleText);

		return matcherNewLine.replaceAll("</p></div><div class='row div-paragraph'><p>");
	}

	private void addImage(Article article) {
		// we find which images the article has !
		List<ArticleImage> articleImages = articleImageService.findByArticle(article);
	
		for (ArticleImage articleImage : articleImages) {
			imageHTML = new StringBuilder("<img class='img-rounded img-responsive pull-left image-article' ");
			imageHTML.append("src='image_article/");
			imageHTML.append(articleImage.getImage().getName());
			imageHTML.append("'> ");
	
			insertImageIntoContext(articleImage.getParagraph());
		}
	}
	
	private void insertImageIntoContext(byte paragraph) {
		matcherNewParagraph = patternNewParagraph.matcher(contentHTML.toString());
		
		int count = 1;
		while (matcherNewParagraph.find()) {
			if (count == paragraph) {
				contentHTML.insert(matcherNewParagraph.start(), imageHTML);
				break;
			}
			count++;
		}
	}
}
