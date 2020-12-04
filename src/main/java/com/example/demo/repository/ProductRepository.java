package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(String name);
	Boolean existsByName(String name);
	List<Product> findByCategoryId(Long categoryId);
//	@Query(value = "SELECT p.id, p.name, p.description, c.name,c.description,p.created_date,p.modified_date FROM tbl_products p INNER JOIN tbl_pro_cate pc ON p.id = pc.product_id INNER JOIN tbl_categories c ON pc.product_id = c.id ORDER BY p.id",nativeQuery = true)
//	List<ProductResponseDtos> getResultProduct();
//	
//	@Query(value = "SELECT p.* FROM tbl_categories c JOIN tbl_pro_cate pc ON c.id = pc.category_id JOIN tbl_products p ON pc.product_id = p.id where c.name = :categoryName", nativeQuery = true)
////	@Query(value =" SELECT new com.example.demo.dtos.CategoryResponseDtos(c) FROM Category c")
//	List<Product> resultAllByCategory(String categoryName);
}
