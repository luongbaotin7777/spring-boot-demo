package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.ProductRequestDtos;
import com.example.demo.dtos.ProductResponseDtos;
import com.example.demo.entities.Product;

public interface ProductService {
    //create
	Product create(ProductRequestDtos dtos);

	//find all
	List<ProductResponseDtos> findAll();
	//find by id
		ProductResponseDtos findById(Long id);
	//update
	Product update(Long id,ProductRequestDtos dtos);
	//delete
	void delete(Long id);
	
	//find by cate id
	List<Product> findByCateId(Long categoryId);
}
