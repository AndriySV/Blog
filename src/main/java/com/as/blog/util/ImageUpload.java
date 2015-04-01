package com.as.blog.util;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {
	
	private List<MultipartFile> images;

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	
}
