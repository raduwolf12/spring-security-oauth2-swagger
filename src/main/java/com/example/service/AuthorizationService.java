package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.entity.Role;
import com.example.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	public UserDetails loadUserByUsername(String userId) {
		com.example.model.entity.User user = repository.findByName(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		Role role = (Role) (user.getRoles().toArray()[0]);
		authorities.add(new SimpleGrantedAuthority(role.getName()));

		return new User(user.getUserName(), user.getPassword(), authorities);
	}

//	private List<SimpleGrantedAuthority> getAuthority(Set<Role> userRoles) {
//		List<?> rolesGrant = new ArrayList<SimpleGrantedAuthority>();
//
//		return null;
//	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
	}

}
