package com.berk.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berk.springsecuritydemo.entitiy.Role;
import com.berk.springsecuritydemo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}
}
