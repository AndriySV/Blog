package com.as.blog.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.entity.Image;
import com.as.blog.service.ArticleImageService;
import com.as.blog.service.ArticleService;
import com.as.blog.service.ImageService;
import com.as.blog.util.ArticleValidator;
import com.as.blog.util.FileUpload;
import com.as.blog.util.ImageValidator;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleValidator articleValidator; 
	
	@Autowired
	private ImageService imageService; 
	
	@Autowired
	private ImageValidator imageValidator; 
	
	@Autowired
	private ArticleImageService articleImageService;
	
	@Value("${root_path}")
	private String rootPath;
	
	@Value("${image_path}")
	private String imagePath;
	
	@RequestMapping
	public String openAdmin(Model model) {
		model.addAttribute(new Article());
		return "admin";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addArticle(Article article, BindingResult bindingResult, String[] imageNames, byte[] paragraphs) {
		articleValidator.validate(article, bindingResult);
		
		if (!bindingResult.hasErrors()) {
			Date currentDate = new Date(new java.util.Date().getTime());
			article.setCreationDate(currentDate);
			articleService.save(article);

			if (imageNames != null & paragraphs != null)
				if (imageNames.length == paragraphs.length) {
					
				ArticleImage articleImage = null;
				
				for (int i = 0; i < imageNames.length; i++) {
					if (!imageNames[i].equals("") & paragraphs[i] > 0) {
						articleImage = new ArticleImage();
						articleImage.setArticle(article);
						articleImage.setImage(imageService.findByName(imageNames[i]));
						articleImage.setParagraph(paragraphs[i]);
						
						articleImageService.save(articleImage);
					} else {
						// TODO Maybe need to write log here (wrong name or paragraph)
					}
				}
				return "redirect:/";
			}
			return "redirect:/";
		} else {
			return "admin";
		}
	}	
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveFile(@ModelAttribute("uploadImage") FileUpload uploadImage) 
			throws IllegalStateException, IOException {
		List<MultipartFile> images = uploadImage.getFiles();
		
		if (null != images && images.size() > 0) {
			for (MultipartFile image : images) {
				String imageName = image.getOriginalFilename();
				
				if (!"".equalsIgnoreCase(imageName)) {
					Image imageEntity = new Image();
					imageEntity.setPath(imagePath);
					imageEntity.setName(imageName);
					
					
					if (imageValidator.validate(imageEntity.getName())) {
						image.transferTo(new File(rootPath + imagePath + imageName));
						imageService.save(imageEntity);
					}
				}
			}
		}
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/recieveImages", method=RequestMethod.GET)
	public @ResponseBody List<Image> recieveImages(){
		List<Image> images = imageService.findAll();
		
		return images;
	}
	
	@RequestMapping(value="/recieveArticles", method=RequestMethod.POST)
	public @ResponseBody List<Article> recieveArticles(){
		List<Article> articles = articleService.findAll();
		
		return articles;
	}
	
	@RequestMapping(value="/deleteArticles", method=RequestMethod.POST)
	public String deleteArticles(long[] articleId){
		if (articleId != null) {
			for (int i = 0; i < articleId.length; i++) {
				articleImageService.deleteByArticleId(articleId[i]);
				articleService.delete(articleId[i]);
			}
		}else{
			System.out.println();
			// TODO Sent the message to the server (It was not chosen any article)
		}
		
		return "redirect:/admin";
	}
}