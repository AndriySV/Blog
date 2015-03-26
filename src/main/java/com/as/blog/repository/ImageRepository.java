package com.as.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.blog.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	public Image findById(long id);
	
	public Image findByName(String name);
	
}
