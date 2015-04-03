package com.as.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.as.blog.entity.Article;
import com.as.blog.repository.ArticleRepository;
import com.as.blog.service.ArticleService;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	@Transactional(readOnly=false)
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

	@Override
	@Transactional(readOnly=false)
	public void delete(long id) {
		articleRepository.delete(id);
	}

}
