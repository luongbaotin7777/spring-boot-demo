package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "tbl_categories")
public class Category extends BaseEntities {
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3,max = 50,message = "Name must be between 3 and 50 characters")
	private String name;
	@Size(max = 200,message = "Description should not be greater than 200 characters")
	private String description;
	@JsonIgnore
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	private List<Product> products;

}
