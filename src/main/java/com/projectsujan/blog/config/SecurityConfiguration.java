package com.projectsujan.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private CostumUserDetailService costumUserDetailService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	protected void Configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.costumUserDetailService).passwordEncoder(getPasswordEncoder());
	}
	
	
	
//	@Bean
//	public UserDetailsService getUsers() {
//		UserDetailsService service = new CostumUserDetailService();
//		return service;
//	}

}
