package com.as.blog.util;

import java.util.Comparator;

import com.as.blog.entity.Article;

/**
 * Sorts the articles in the descending order. 
 */
public class DescendingSortArticle implements Comparator<Article> {
	
	/**
	 * Sorts the articles in the descending order. 
	 */
	@Override
	public int compare(Article article1, Article article2) {
		
		if (article1.getId() > article2.getId()) {
			return -1;
		} else if (article1.getId() < article2.getId()) {
			return 1;
		} else if (article1.getTitle().compareToIgnoreCase(article2.getTitle()) > 0) {
			return -1;
		} else if (article1.getTitle().compareToIgnoreCase(article2.getTitle()) < 0) {
			return 1;
		} else if (article1.getContent().compareToIgnoreCase(article2.getContent()) > 0) {
			return -1;
		} else if (article1.getContent().compareToIgnoreCase(article2.getContent()) < 0) {
			return 1;
		} else if (article1.getCreationDate().compareTo(article2.getCreationDate()) > 0) {
			return -1;
		} else if (article1.getCreationDate().compareTo(article2.getCreationDate()) < 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
