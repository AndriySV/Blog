package com.as.blog.service;

import com.as.blog.entity.Image;

public interface ImageService {
	
	public void save(Image image);
	
	public Image findByPath(String path);

}
