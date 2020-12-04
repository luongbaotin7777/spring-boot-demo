package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);
	Boolean existsByName(String name);
	@Override
	default long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
