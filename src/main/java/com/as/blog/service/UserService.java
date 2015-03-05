package com.as.blog.service;

import java.util.List;

import com.as.blog.entity.User;

public interface UserService {

	public void save(User user);
	
	public List<User> findByNameOrEmail(String name, String email);
	
}
