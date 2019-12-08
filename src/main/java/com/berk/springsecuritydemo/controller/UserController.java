package com.berk.springsecuritydemo.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berk.springsecuritydemo.entitiy.Role;
import com.berk.springsecuritydemo.entitiy.User;
import com.berk.springsecuritydemo.service.RoleService;
import com.berk.springsecuritydemo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/user")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	
	@GetMapping("/add")
	public void addUser() {
		User u = new User();
		u.setFirstName("Berk");
		u.setLatsName("Yavuz");
		u.setPassword("berk123");
		u.setEmail("berkyavuz@gmail.com");
		Set<Role> r = new HashSet<Role>();
		
		Role r1 = new Role();
		r1.setName("ADMIN");
		roleService.saveRole(r1);
		
		Role r2 = new Role();
		r2.setName("USER");
		roleService.saveRole(r2);
		
		r.add(r1);
		r.add(r2);
		u.setRoles(r);
		userService.saveUser(u);
		
	}
}
