package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.RoleRequestDtos;
import com.example.demo.dtos.RoleResponseDtos;
import com.example.demo.service.RoleService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/role")
@Api(value = "Role APIs")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public List<RoleResponseDtos> findAll() {
		return roleService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(roleService.findById(id));
		}catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody RoleRequestDtos dtos) {
		try {
			return ResponseEntity.ok(roleService.create(dtos));
		}catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid  @PathVariable Long id,@RequestBody RoleRequestDtos dtos) {
		try {
			return ResponseEntity.ok(roleService.update(id, dtos));
		}catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		try {
			roleService.detele(id);
			return "Delete success!";
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
}
