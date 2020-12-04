package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CustomerReqDtos;
import com.example.demo.dtos.CustomerResDtos;
import com.example.demo.entities.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public List<CustomerResDtos> findAll() {
//		return  customerRepository.findAll().stream().map(customerMapper::customerToCustomerResDto).collect(Collectors.toList());
		return customerMapper.customerToCustomerResDtos(customerRepository.findAll());
	}

	@Override
	public CustomerResDtos FindById(Long id) {
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id " + id + " not found"));
		return customerMapper.customerToCustomerResDto(existingCustomer);
	}

	@Override
	public Customer create(CustomerReqDtos dtos) {
		Customer customer = new Customer();
		customer.setFullname(dtos.getFullname());
		customer.setAge(dtos.getAge());
		customer.setDob(dtos.getDob());

		customer.setCreatedDate(new Date());
		return customerRepository.save(customerMapper.toCustomer(dtos));
	}

	@Override
	public Customer update(Long id, CustomerReqDtos dtos) {
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id " + id + " not found"));

		if (customerRepository.existsByFullname(dtos.getFullname())) {
			throw new RuntimeException("Full name: " + dtos.getFullname() + "is already taken");
		}
		existingCustomer.setFullname(dtos.getFullname());

		existingCustomer.setAge(dtos.getAge());
		existingCustomer.setDob(dtos.getDob());
		existingCustomer.setModifiedDate(new Date());
		return customerRepository.save(customerMapper.toCustomer(dtos));

	}

}
