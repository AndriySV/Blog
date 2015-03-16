package com.as.blog.service;

import com.as.blog.entity.Article;

public interface ArticleService {

	public void save(Article article);
	
	public Article findByTitle(String title);
	
}
