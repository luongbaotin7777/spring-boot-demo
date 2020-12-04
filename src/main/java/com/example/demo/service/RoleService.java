package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.RoleRequestDtos;
import com.example.demo.dtos.RoleResponseDtos;
import com.example.demo.entities.Role;

public interface RoleService {

	List<RoleResponseDtos> findAll();
	RoleResponseDtos findById(Long id);
	Role create(RoleRequestDtos dtos);
	Role update(Long id, RoleRequestDtos dtos);
	void detele(Long id);
}
