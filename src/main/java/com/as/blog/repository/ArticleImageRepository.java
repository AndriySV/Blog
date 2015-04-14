package com.as.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;

public interface ArticleImageRepository extends JpaRepository<ArticleImage, Long> {

	public List<ArticleImage> findByArticle(Article article);
	
	public List<ArticleImage> findByArticleId(long articleId);
	
	@Modifying
	@Query("DELETE FROM ArticleImage WHERE article_id = ?1")
	public void deleteByArticleId(long articleId);
	
}