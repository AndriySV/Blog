package com.as.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
