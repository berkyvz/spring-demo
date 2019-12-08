package com.berk.springsecuritydemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.berk.springsecuritydemo.entitiy.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value= "SELECT * FROM USER WHERE FIRST_NAME = ?1", nativeQuery= true)
	public List<User> findByName(String username);
	
	@Query(value= "SELECT * FROM USER WHERE EMAIL = ?1", nativeQuery= true)
	public User findByEmail(String email);
	
	
}
