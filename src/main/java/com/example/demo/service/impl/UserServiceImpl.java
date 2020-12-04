package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.AddToRoleDtos;
import com.example.demo.dtos.UserRequestDtos;
import com.example.demo.dtos.UserResponseDtos;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserResponseDtos> findAll() {
		return userMapper.toUserDTOs(userRepository.findAll());
	}

	@Override
	public UserResponseDtos findById(Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		return userMapper.toUserDTO(existingUser);
	}

	@Override
	public User create(UserRequestDtos dtos) {
		if (userRepository.existsByusername(dtos.getUsername())) {
			throw new RuntimeException("username: " + dtos.getUsername() + "is already taken");
		}
		if (userRepository.existsByEmail(dtos.getEmail())) {
			throw new RuntimeException("Email: " + dtos.getEmail() + "is already taken");
		}
		User user = userMapper.toUser(dtos);

		user.setCreatedDate(new Date());

		return userRepository.save(user);

	}

	@Override
	public User update(Long id, UserRequestDtos dtos) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		if (!existingUser.getUsername().equals(dtos.getUsername())) {
			if (userRepository.existsByusername(dtos.getUsername())) {
				throw new RuntimeException("username: " + dtos.getUsername() + "is already taken");
			}
		}
		if (!existingUser.getEmail().equals(dtos.getEmail())) {
			if (userRepository.existsByEmail(dtos.getEmail())) {
				throw new RuntimeException("Email: " + dtos.getEmail() + "is already taken");
			}
		}
		existingUser = userMapper.toUser(dtos);
		existingUser.setId(id);
		existingUser.setModifiedDate(new Date());
		return userRepository.save(existingUser);
	}

	@Override
	public void delete(Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		userRepository.delete(existingUser);

	}

	@Override
	public void AddUserRole(AddToRoleDtos dtos) {
		User existingUser = userRepository.findByUsername(dtos.getUsername());
		if (existingUser == null) {
			throw new RuntimeException("User name: " + dtos.getUsername() + " not found");
		}

		List<Role> roles = new ArrayList<>();
		List<Role> currentRole = existingUser.getRoles();

		roles.removeAll(currentRole);
		existingUser = userRepository.save(existingUser);
		for (String rolename : dtos.getRoles()) {
			Role existingRole = roleRepository.findByName(rolename);
			if (existingRole != null) {

				roles.add(existingRole);
			} else {
				throw new RuntimeException("Role name: " + rolename + " not found");
			}

		}
		existingUser.setRoles(roles);
		userRepository.save(existingUser);

	}

	@Override
	public List<User> findByRole(String roleName) {
		Boolean existingRole = roleRepository.existsByName(roleName);
		if (!existingRole) {
			throw new RuntimeException("Role name: " + roleName + " not found");
		}
		return userRepository.resultAllByRole(roleName);
	}

}
