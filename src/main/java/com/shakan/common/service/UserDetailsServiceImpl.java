package com.shakan.common.service;

import com.shakan.common.models.Users;
import com.shakan.common.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Users user = userRepository.findByUserId(userId)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with userId: " + userId));

		return UserDetailsImpl.build(user);
	}

}