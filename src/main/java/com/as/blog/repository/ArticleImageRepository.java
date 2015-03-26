package com.as.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;

public interface ArticleImageRepository extends JpaRepository<ArticleImage, Long> {

	public List<ArticleImage> findByArticle(Article article);
	
}
