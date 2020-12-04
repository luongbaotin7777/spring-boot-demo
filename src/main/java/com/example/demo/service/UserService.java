package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.AddToRoleDtos;
import com.example.demo.dtos.UserRequestDtos;
import com.example.demo.dtos.UserResponseDtos;
import com.example.demo.entities.User;

public interface UserService {

	List<UserResponseDtos> findAll();
	UserResponseDtos findById(Long id);
	User create(UserRequestDtos dtos);
	User update(Long id, UserRequestDtos dtos);
	List<User> findByRole(String roleName);
	void AddUserRole(AddToRoleDtos dtos);
	void delete(Long id);
}
