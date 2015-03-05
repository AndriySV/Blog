package com.as.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByNameOrEmail(String name, String email);
	
}
