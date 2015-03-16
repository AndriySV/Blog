package com.as.blog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.as.blog.entity.Article;
import com.as.blog.service.ArticleService;

@Component
public class ArticleValidator implements Validator {

	@Autowired
	private ArticleService articleService; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Article.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Article currentArticle = (Article) object;
		Article existingArticle = articleService.findByTitle(currentArticle.getTitle());
		
		if (existingArticle != null) {
			errors.rejectValue("title", "error-title", "Стаття із даним заголовком уже існує !");
		}
	}

}