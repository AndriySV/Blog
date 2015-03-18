package com.as.blog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.as.blog.entity.Image;
import com.as.blog.service.ImageService;

@Component
public class ImageValidator {
	
	@Autowired
	private ImageService imageService;

	public boolean validate(String imagePath) {
		Image existingImage = imageService.findByPath(imagePath);
		
		if (existingImage == null) {
			return true;
		} else {
			return false;
		}
	}

}