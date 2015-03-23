package com.as.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.blog.entity.Article;
import com.as.blog.repository.ArticleRepository;
import com.as.blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public void save(Article article) {
		articleRepository.save(article);
	}
	
	@Override
	public Article findByTitle(String title) {
		return articleRepository.findByTitle(title);
	}

	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

}
