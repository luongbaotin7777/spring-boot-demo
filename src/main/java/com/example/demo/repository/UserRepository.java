package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByusername(String username);
	Boolean existsByEmail(String email);
	
	User findByUsername(String username);
	
	@Query(value = "SELECT u.* FROM tbl_users u JOIN tbl_user_roles ur ON u.id = ur.user_id JOIN tbl_roles r ON ur.role_id = r.id where r.name= :roleName", nativeQuery = true)
//@Query(value =" SELECT new com.example.demo.dtos.CategoryResponseDtos(c) FROM Category c")
	List<User> resultAllByRole(String roleName);
}
