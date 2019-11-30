package com.berk.springsecuritydemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berk.springsecuritydemo.entitiy.User;
import com.berk.springsecuritydemo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public List<User> getUserByName(String name) {
		return userRepo.findByName(name);
	}
	
	
}
