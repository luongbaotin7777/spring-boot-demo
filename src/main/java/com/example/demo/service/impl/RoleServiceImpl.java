package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.RoleRequestDtos;
import com.example.demo.dtos.RoleResponseDtos;
import com.example.demo.entities.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<RoleResponseDtos> findAll() {
		return roleMapper.toRoleDTOs(roleRepository.findAll());
	}

	@Override
	public RoleResponseDtos findById(Long id) {
		Role existingRole = roleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		return roleMapper.toRoleDTO(existingRole);
	}

	@Override
	public Role create(RoleRequestDtos dtos) {
		if (roleRepository.existsByName(dtos.getName())) {
			throw new RuntimeException("role name: " + dtos.getName() + " is already taken");
		}
		Role role = roleMapper.toRole(dtos);

		role.setCreatedDate(new Date());
		return roleRepository.save(role);
	}

	@Override
	public Role update(Long id, RoleRequestDtos dtos) {
		Role existingRole = roleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		if (!existingRole.getName().equals(dtos.getName())) {
			if (roleRepository.existsByName(dtos.getName())) {
				throw new RuntimeException("Name: " + dtos.getName() + " is already taken");
			}	
		}
		
		existingRole = roleMapper.toRole(dtos);
		existingRole.setId(id);
		existingRole.setModifiedDate(new Date());
		return roleRepository.save(existingRole);
	}

	@Override
	public void detele(Long id) {
		Role existingRole = roleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		roleRepository.delete(existingRole);

	}

}
