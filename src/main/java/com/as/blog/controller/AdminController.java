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
import com.as.blog.service.ArticleService;
import com.as.blog.util.ArticleValidator;
import com.as.blog.util.FileUpload;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleValidator articleValidator; 
	
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
	public String addArticle(Article article, BindingResult bindingResult, String image) {
		
		System.out.println("--------------  "  + image);
		
		articleValidator.validate(article, bindingResult);
		
		if (!bindingResult.hasErrors()) {
			
			Date currentDate = new Date(new java.util.Date().getTime());
			article.setCreationDate(currentDate);
			
			articleService.save(article);
			
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
					image.transferTo(new File(rootPath + pictureSaveDirectory + imageName));
				}
			}
		}
		return "redirect:/admin";
	}
	
}