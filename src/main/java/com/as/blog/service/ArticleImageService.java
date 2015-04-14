package com.as.blog.service;

import java.util.List;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;

public interface ArticleImageService {
	
	public void save(ArticleImage articleImage);
	
	public List<ArticleImage> findByArticleId(long articleId);
	
	public List<ArticleImage> findByArticle(Article article);
	
	public void deleteByArticleId(long articleId);
	
}
