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
import org.springframework.web.multipart.MultipartFile;

import com.as.blog.entity.Article;
import com.as.blog.entity.Image;
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
	
	@Value("${root_path}")
	private String rootPath;
	
	@Value("${picture_save_directory}")
	private String pictureSaveDirectory;
	
	@RequestMapping
	public String openAdmin(Model model) {
		model.addAttribute(new Article());
		return "admin";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addArticle(Article article, BindingResult bindingResult) {
		
		articleValidator.validate(article, bindingResult);
		
		if (!bindingResult.hasErrors()) {
			
			Date currentDate = new Date(new java.util.Date().getTime());
			article.setCreationDate(currentDate);
			
			articleService.save(article);
			
			// TODO invoke the method which displays this article on the main page !
			
			return "redirect:/";
		} else {
			return "admin";
		}
	}
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveFile(@ModelAttribute("uploadImage") FileUpload uploadImage) 
			throws IllegalStateException, IOException {
		String imagePath = null;
		
		List<MultipartFile> images = uploadImage.getFiles();
		
		if (null != images && images.size() > 0) {
			for (MultipartFile image : images) {
				String imageName = image.getOriginalFilename();
				
				if (!"".equalsIgnoreCase(imageName)) {
					imagePath =  pictureSaveDirectory + imageName;
					
					Image imageEntity = new Image();
					imageEntity.setPath(imagePath);
					
					if (imageValidator.validate(imageEntity.getPath())) {
						image.transferTo(new File(rootPath + imagePath));
						imageService.save(imageEntity);
					}
				}
			}
		}
		return "redirect:/admin";
	}
	
}