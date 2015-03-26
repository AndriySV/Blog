package com.as.blog.service;

import java.util.List;

import com.as.blog.entity.Image;

public interface ImageService {
	
	public void save(Image image);
	
	public Image findById(long id);
	
	public Image findByName(String name);
	
	public List<Image> findAll();

}
