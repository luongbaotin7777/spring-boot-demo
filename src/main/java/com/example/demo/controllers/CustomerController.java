package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CustomerReqDtos;
import com.example.demo.dtos.CustomerResDtos;
import com.example.demo.service.CustomerService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer Apis")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public List<CustomerResDtos> findAll(){
		return customerService.findAll();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		 try {
			 return ResponseEntity.ok(customerService.FindById(id));
		 }catch(Exception e) {
			 return ResponseEntity.status(500).body(e.getMessage());
		 }
	}
	@PostMapping
	public ResponseEntity<CustomerReqDtos> create(@RequestBody CustomerReqDtos dtos){
		customerService.create(dtos);
		return ResponseEntity.status(HttpStatus.CREATED).body(dtos);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody CustomerReqDtos dtos){
		try {
			customerService.update(id, dtos);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);
		}catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
}
