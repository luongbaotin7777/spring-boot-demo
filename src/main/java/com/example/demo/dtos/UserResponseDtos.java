package com.example.demo.dtos;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDtos {
	private Long id;
	private String fullname;
	private Date dob;
	private String age;

	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_date")
	private Date modifiedDate;
}
