package com.as.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.repository.ArticleImageRepository;
import com.as.blog.service.ArticleImageService;

@Service
public class ArticleImageServiceImpl implements ArticleImageService {

	@Autowired
	private ArticleImageRepository articleImageRepository;
	
	@Override
	public void save(ArticleImage articleImage) {
		articleImageRepository.saveAndFlush(articleImage);
	}

	@Override
	public List<ArticleImage> findByArticle(Article article) {
		return articleImageRepository.findByArticle(article);
	}

}
