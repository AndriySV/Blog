package com.as.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.as.blog.entity.Image;
import com.as.blog.repository.ImageRepository;
import com.as.blog.service.ImageService;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	@Transactional(readOnly=false)
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
