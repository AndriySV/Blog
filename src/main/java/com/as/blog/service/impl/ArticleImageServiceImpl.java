package com.as.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.repository.ArticleImageRepository;
import com.as.blog.service.ArticleImageService;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ArticleImageServiceImpl implements ArticleImageService {

	@Autowired
	private ArticleImageRepository articleImageRepository;
	
	@Override
	@Transactional(readOnly=false)
	public void save(ArticleImage articleImage) {
		articleImageRepository.saveAndFlush(articleImage);
	}

	@Override
	public List<ArticleImage> findByArticle(Article article) {
		return articleImageRepository.findByArticle(article);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteByArticleId(long articleId) {
		articleImageRepository.deleteByArticleId(articleId);
	}

	@Override
	public List<ArticleImage> findByArticleId(long articleId) {
		return articleImageRepository.findByArticleId(articleId);
	}

}
