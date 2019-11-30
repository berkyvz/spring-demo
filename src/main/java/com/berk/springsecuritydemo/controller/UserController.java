package com.berk.springsecuritydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.berk.springsecuritydemo.entitiy.User;
import com.berk.springsecuritydemo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getHome(@RequestParam("name") String name) {
		return userService.getUserByName(name);
	}
}
