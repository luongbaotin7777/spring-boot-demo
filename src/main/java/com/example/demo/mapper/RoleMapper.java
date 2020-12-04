package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dtos.RoleRequestDtos;
import com.example.demo.dtos.RoleResponseDtos;
import com.example.demo.entities.Role;
@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleResponseDtos toRoleDTO(Role role);

    List<RoleResponseDtos> toRoleDTOs(List<Role> roles);

    Role toRole(RoleRequestDtos roleDTO);
}

