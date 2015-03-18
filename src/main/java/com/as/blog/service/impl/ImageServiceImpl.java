package com.as.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.blog.entity.Image;
import com.as.blog.repository.ImageRepository;
import com.as.blog.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public void save(Image image) {
		imageRepository.save(image);
	}

	@Override
	public Image findByPath(String path) {
		return imageRepository.findByPath(path);
	}

}
