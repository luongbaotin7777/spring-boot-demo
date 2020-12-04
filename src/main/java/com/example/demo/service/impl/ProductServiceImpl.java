package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductRequestDtos;
import com.example.demo.dtos.ProductResponseDtos;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.excample.demo.exception.NotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private ProductMapper productMapper;

	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
			ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.productMapper = productMapper;
	}

	@Override
	public List<ProductResponseDtos> findAll() {
		return productMapper.toProductDTOs(productRepository.findAll());
	}

	@Override
	public Product create(ProductRequestDtos dtos) {

		if (productRepository.existsByName(dtos.getName())) {

			throw new RuntimeException("name: " + dtos.getName() + " is alrady taken");
		}
		Product product =  productMapper.toProduct(dtos);
		Category existing = categoryRepository.findById(dtos.getCategoryId())
				.orElseThrow(() -> new RuntimeException("CategoryId Not Found"));

		product.setCategory(existing);
		product.setCreatedDate(new Date());
		return productRepository.save(product);

	}

	@Override
	public List<Product> findByCateId(Long categoryId) {
		Optional<Category> existing = categoryRepository.findById(categoryId);

		if (existing != null && existing.isPresent()) {
			return productRepository.findByCategoryId(categoryId);
		}
		throw new NotFoundException("Id: " + categoryId + " not found");

	}

	@Override
	public ProductResponseDtos findById(Long id) {
		Product existing = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		return productMapper.toProductDTO(existing);
	}

	@Override
	public Product update(Long id, ProductRequestDtos dtos) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		if (!product.getName().equals(dtos.getName())) {
			if (productRepository.existsByName(dtos.getName())) {
				throw new RuntimeException("Name: " + dtos.getName() + " is already taken");
			}
		}
       
		product = productMapper.toProduct(dtos);
		product.setId(id);
		product.setModifiedDate(new Date());
		
		Category existingCategory = categoryRepository.findById(dtos.getCategoryId())
				.orElseThrow(() -> new RuntimeException("id: " + dtos.getCategoryId() + " not found"));
		product.setCategory(existingCategory);
		

		product.setModifiedDate(new Date());
		return productRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		Product existing = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id: " + id + " not found"));
		productRepository.delete(existing);

	}

}
