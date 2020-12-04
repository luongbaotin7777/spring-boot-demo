package com.example.demo.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDtos {

	private String username;
	private String firstname;
	private String lastname;
	private Date dob;
	private String email;

}
