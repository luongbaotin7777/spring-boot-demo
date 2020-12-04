package com.example.demo.dtos;

import java.util.Date;

import javax.persistence.Column;

import com.example.demo.entities.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDtos {
	private Long id;
	private String name;
	private float price;
	private String description;
	private Category category;
	
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_date")
	private Date modifiedDate;
}
