package com.as.blog.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
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

import com.as.blog.bean.ImageParagraph;
import com.as.blog.entity.Article;
import com.as.blog.entity.ArticleImage;
import com.as.blog.entity.Image;
import com.as.blog.service.ArticleImageService;
import com.as.blog.service.ArticleService;
import com.as.blog.service.ImageService;
import com.as.blog.util.ArticleValidator;
import com.as.blog.util.FileUpload;
import com.as.blog.util.ImageValidator;

/**
 * @author Андрій
 *	Processes data from admin.jsp
 */
@Controller
@RequestMapping(value = "/admin")
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

	/**
	 * Creates the article object which is used for adding article into the database
	 * @return the value which redirects to the page admin.jsp
	 */
	@RequestMapping
	public String openAdmin(Model model) {
		model.addAttribute(new Article());
		return "admin";
	}

	/**
	 * Saves an article to the database 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addArticle(Article article, BindingResult bindingResult,
			String[] imageNames, byte[] paragraphs) {
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
							articleImage.setImage(imageService
									.findByName(imageNames[i]));
							articleImage.setParagraph(paragraphs[i]);

							articleImageService.save(articleImage);
						} else {
							// TODO Maybe need to write log here (wrong name or
							// paragraph)
						}
					}
					return "redirect:/";
				}
			return "redirect:/";
		} else {
			return "admin";
		}
	}

	/**
	 *  Saves an image to the database
	 */
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
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
						image.transferTo(new File(rootPath + imagePath
								+ imageName));
						imageService.save(imageEntity);
					}
				}
			}
		}
		return "redirect:/admin";
	}

	/**
	 * @return all images from the database.
	 */
	@RequestMapping(value = "/recieveImages", method = RequestMethod.POST)
	public @ResponseBody List<Image> receiveAllImages() {
		List<Image> images = imageService.findAll();

		return images;
	}

	/**
	 * @return all articles from the database
	 */
	@RequestMapping(value = "/recieveArticles", method = RequestMethod.POST)
	public @ResponseBody List<Article> receiveArticles() {
		List<Article> articles = articleService.findAll();

		return articles;
	}

	/**
	 * Deletes articles with the specified id
	 */
	@RequestMapping(value = "/deleteArticles", method = RequestMethod.POST, 
					produces = "application/json; charset=utf-8")
	public @ResponseBody List<String> deleteArticles(long[] articleId) {
		List<String> articleTitles = new LinkedList<String>();

		if (articleId != null) {
			for (int i = 0; i < articleId.length; i++) {
				articleTitles.add(articleService.findById(articleId[i]).getTitle());

				articleImageService.deleteByArticleId(articleId[i]);
				articleService.delete(articleId[i]);
			}
			return articleTitles;

		} else {
			articleTitles
					.add("Жодна стаття не була видалена. \nОберіть статті, які бажаєте видилити.");
			return articleTitles;
		}
	}

	/**
	 * @return the article with the specified id
	 */
	@RequestMapping(value="/receiveArticle", method = RequestMethod.POST,
					produces = "application/json; charset=utf-8")
	public @ResponseBody Article receiveArticle(Long id) {
		return articleService.findById(id);
	}
	
	/**
	 * @return the objects ImageParagraphs with the specified id
	 */
	@RequestMapping(value="/receiveImageParagraphs", method = RequestMethod.POST,
			produces = "application/json; charset=utf-8")
	public @ResponseBody List<ImageParagraph> receiveImageParagraphs(Long id){
		List<ArticleImage> articleImages = articleImageService.findByArticleId(id);
		List<ImageParagraph> imageParagraphs = null;
		
		if (articleImages != null) {
			imageParagraphs = new LinkedList<ImageParagraph>();
			ImageParagraph imageParagraph;
		
			for (ArticleImage articleImage : articleImages) {
				imageParagraph = new ImageParagraph();
				imageParagraph.setImageName(articleImage.getImage().getName());
				imageParagraph.setParagraph(articleImage.getParagraph());
				
				imageParagraphs.add(imageParagraph);
			}
		}
		return imageParagraphs;
	}

	/**
	 * Updates the specified article. 
	 */
	@RequestMapping(value="/updateArticle", method=RequestMethod.POST)
	public String updateArticle(Article article, BindingResult bindingResult, Model model) {
		articleValidator.validate(article, bindingResult);
	
		if (!bindingResult.hasErrors()) {
			articleService.update(article.getId(), article.getTitle(), article.getContent());
			return "redirect:/";
		} else {
			model.addAttribute("error", "true"); 
			return "admin";
		}
	}

}