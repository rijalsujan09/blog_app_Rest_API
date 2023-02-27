package com.projectsujan.blog.services;

import java.util.List;

import com.projectsujan.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(Integer id, UserDto userDto);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer id);

}
