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

import com.example.demo.dtos.CategoryRequestDtos;
import com.example.demo.dtos.CategoryResponseDtos;
import com.example.demo.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/category")
@Api(value = "Category APIs")
public class CategoryController {

	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
		
	}
	@ApiOperation(value = "Xem danh sách Category", response = List.class)
	@GetMapping()
	public List<CategoryResponseDtos> findAll() {
		return categoryService.findAll();
	}
	@ApiOperation(value = "Xem danh sách theo id", response = List.class)
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
		try {
			return ResponseEntity.ok(categoryService.findById(id));
		}catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		
	}
	@ApiOperation(value = "Thêm category", response = List.class)
	@PostMapping()
	public ResponseEntity<?> create(@Valid @ApiParam(value = "Đối tượng User cần tạo mới", required = true) @RequestBody CategoryRequestDtos dtos) {
		try {
			return ResponseEntity.ok(categoryService.create(dtos));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@ApiOperation(value = "Cập nhật category", response = List.class)
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable(name = "id") Long id, @RequestBody CategoryRequestDtos dtos) {
		try {
			return ResponseEntity.ok(categoryService.update(id, dtos));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@ApiOperation(value =" Xóa Category", response = List.class)
	@DeleteMapping("/{id}")
	public String delete(@PathVariable(name="id")Long id){
		try {
			categoryService.delete(id);
			return "Delete success!";
		}catch(Exception e) {
			return e.getMessage();
		}
	}

}
