package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.CategoryRequestDtos;
import com.example.demo.dtos.CategoryResponseDtos;
import com.example.demo.entities.Category;

public interface CategoryService {
	//Create
	Category create(CategoryRequestDtos dtos);
	//find all
	List<CategoryResponseDtos> findAll();
	//find by id
	CategoryResponseDtos findById(Long id);
	//update
	Category update(Long id,CategoryRequestDtos dtos);
	//delete
	void delete(Long id);
}
