package com.corenuts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.corenuts.dto.UserDetailsDTO;
import com.corenuts.repositories.UserDetailRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailRepository repository;

	// loading model class user object
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		com.corenuts.entity.UserDetails user = repository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not exist" + email));

		// converting into Spring Security User object
		return UserDetailsMapper.toDTO(user);
	}
}
