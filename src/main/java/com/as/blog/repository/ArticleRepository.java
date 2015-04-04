package com.as.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.blog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	public Article findByTitle(String title);

	public Article findById(long id);
	
}
