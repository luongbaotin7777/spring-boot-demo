package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.CustomerReqDtos;
import com.example.demo.dtos.CustomerResDtos;
import com.example.demo.entities.Customer;

public interface CustomerService {
	
	List<CustomerResDtos> findAll();
	CustomerResDtos FindById(Long id);
	Customer create(CustomerReqDtos dtos);
	Customer update(Long id,CustomerReqDtos dtos);
}
