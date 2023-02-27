package com.projectsujan.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectsujan.blog.entity.User;
import com.projectsujan.blog.exceptions.UserFoundException;
import com.projectsujan.blog.repositories.UserRepository;

@Service
public class CostumUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepository.findByEmail(username)
				.orElseThrow(() -> new UserFoundException("User", "emai: ", username));
		UserDetail_Info userDetail_Info = new UserDetail_Info(user);
		return userDetail_Info;

	}

}
