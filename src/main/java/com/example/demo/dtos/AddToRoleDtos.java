package com.example.demo.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToRoleDtos {

	private String username;
	private List<String> roles;
}
