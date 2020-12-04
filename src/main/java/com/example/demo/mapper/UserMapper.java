package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dtos.UserRequestDtos;
import com.example.demo.dtos.UserResponseDtos;
import com.example.demo.entities.User;
@Mapper(componentModel = "spring")
public interface UserMapper {
	UserResponseDtos toUserDTO(User User);

    List<UserResponseDtos> toUserDTOs(List<User> Users);

    User toUser(UserRequestDtos UserDTO);
}
