package com.example.demo.dtos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.example.demo.entities.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDtos {

	private Long id;
	private String name;
	private String description;
	private List<Product> products;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_date")
	private Date modifiedDate;
}
