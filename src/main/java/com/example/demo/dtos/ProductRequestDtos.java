package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDtos {

	private String name;
	private float price;
	private String description;
	private Long categoryId;
	
}
