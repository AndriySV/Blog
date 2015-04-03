package com.as.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.as.blog.entity.User;
import com.as.blog.repository.UserRepository;
import com.as.blog.service.UserService;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=false)
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findByNameOrEmail(String name, String email) {
		return userRepository.findByNameOrEmail(name, email);
	}

}
