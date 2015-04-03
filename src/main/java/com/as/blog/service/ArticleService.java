package com.as.blog.service;

import java.util.List;

import com.as.blog.entity.Article;

public interface ArticleService {

	public void save(Article article);
	
	public Article findByTitle(String title);
	
	public List<Article> findAll();
	
	public void delete(long id);
	
}
