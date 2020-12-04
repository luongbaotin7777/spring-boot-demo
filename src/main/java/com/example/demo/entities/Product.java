package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "tbl_products")
public class Product extends BaseEntities {
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3,max = 50,message = "Name must be between 3 and 50 characters")
	private String name;
	@NotNull()
	@Positive
	private float price;
	@Size(max = 200,message = "Description should not be greater than 200 characters")
	private String description;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;


	
	
	

}