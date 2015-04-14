package com.as.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.as.blog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	public Article findByTitle(String title);

	public Article findById(long id);

	@Modifying
	@Query("UPDATE Article SET title=?2, content=?3 where id = ?1")
	public void update(long id, String title, String content);
	
}
