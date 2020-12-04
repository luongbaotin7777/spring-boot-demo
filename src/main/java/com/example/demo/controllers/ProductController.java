package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductRequestDtos;
import com.example.demo.dtos.ProductResponseDtos;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
@Api(value = "Product APIs")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService,ProductMapper productMapper) {
		this.productService = productService;
		
	}
	@ApiOperation(value = "Xem danh sách Product", response = List.class)
	@GetMapping
	public List<ProductResponseDtos> findAll(){
		return  productService.findAll();
	}
	

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<?> findByCate(@PathVariable Long categoryId) {
		try {
			 return ResponseEntity.ok(productService.findByCateId(categoryId));
		}catch(Exception e){
			return ResponseEntity.status(500).body(e.getMessage());
		}
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id")Long id){
		try {
			return ResponseEntity.ok(productService.findById(id));
		}catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody ProductRequestDtos dtos){
		try {
			return ResponseEntity.ok(productService.create(dtos));
		}catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable(name = "id")Long id,@RequestBody ProductRequestDtos dtos){
		try {
			return ResponseEntity.ok(productService.update(id, dtos));
		}catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable(name="id")Long id){
		try {
			productService.delete(id);
			return "Delete success!";
		}catch(Exception e) {
			return e.getMessage();
		}
	}

	
}
