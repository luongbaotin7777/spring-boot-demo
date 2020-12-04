package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.CategoryRequestDtos;
import com.example.demo.dtos.CategoryResponseDtos;
import com.example.demo.entities.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.excample.demo.exception.NotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	private CategoryMapper categoryMapper;

	public CategoryServiceImpl(CategoryRepository categoryRepository,CategoryMapper categoryMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public Category create(CategoryRequestDtos dtos) {

		if (categoryRepository.existsByName(dtos.getName())) {
			throw new IllegalArgumentException("Name: " + dtos.getName() + " is already taken");
		}
		Category category = categoryMapper.toCategory(dtos);
		return categoryRepository.save(category);

	}

	@Override
	public List<CategoryResponseDtos> findAll() {
		return categoryMapper.toCategoryDTOs(categoryRepository.findAll()) ;
	}

	@Override
	public CategoryResponseDtos findById(Long id) {
		Category existingCategory = categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Id: " + id + " not found"));
		return categoryMapper.toCategoryDTO(existingCategory);
	}

	@Override
	public Category update(Long id, CategoryRequestDtos dtos) {
		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id: " + id + "not found"));

		if (categoryRepository.existsByName(dtos.getName())) {
			throw new RuntimeException("Name: " + dtos.getName() + " is already taken");
		}
		existingCategory = categoryMapper.toCategory(dtos);
		existingCategory.setId(id);
		
		existingCategory.setModifiedDate(new Date());
		return categoryRepository.save(existingCategory);

	}

	@Override
	public void delete(Long id) {
		Category existing = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id: " + id + " not found"));
		categoryRepository.delete(existing);

	}

}
