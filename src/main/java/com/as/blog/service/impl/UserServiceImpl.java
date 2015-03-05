package com.as.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.blog.entity.User;
import com.as.blog.repository.UserRepository;
import com.as.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findByNameOrEmail(String name, String email) {
		return userRepository.findByNameOrEmail(name, email);
	}

}
