package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dtos.CustomerReqDtos;
import com.example.demo.dtos.CustomerResDtos;
import com.example.demo.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	CustomerResDtos customerToCustomerResDto(Customer customer);
	List<CustomerResDtos> customerToCustomerResDtos(List<Customer> customer);
	
	Customer toCustomer(CustomerReqDtos customerResDtos);
}

