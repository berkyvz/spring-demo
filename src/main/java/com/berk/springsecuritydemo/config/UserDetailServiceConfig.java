package com.berk.springsecuritydemo.config;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.berk.springsecuritydemo.entitiy.User;
import com.berk.springsecuritydemo.service.UserService;

@Service
public class UserDetailServiceConfig implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email + " is not registered yet.");
		}

		return new UserDetailsImp(user);

	}

}
