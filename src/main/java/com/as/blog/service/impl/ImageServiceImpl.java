package com.as.blog.service.impl;

import java.util.List;

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
	public Image findById(long id) {
		return imageRepository.findById(id);
	}

	@Override
	public Image findByName(String name) {
		return imageRepository.findByName(name);
	}

	@Override
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

}
