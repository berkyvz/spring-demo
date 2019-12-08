package com.berk.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berk.springsecuritydemo.entitiy.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
