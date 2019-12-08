package com.berk.springsecuritydemo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.berk.springsecuritydemo.entitiy.Role;
import com.berk.springsecuritydemo.entitiy.User;

public class UserDetailsImp implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserDetailsImp(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		ArrayList<Role> roleList = new ArrayList<Role>(user.getRoles());
		for (int i = 0; i < roleList.size(); i++) {
			grantedAuthorities.add(new SimpleGrantedAuthority(roleList.get(i).getName()));
		}
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getFirstName()+" "+user.getLatsName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
