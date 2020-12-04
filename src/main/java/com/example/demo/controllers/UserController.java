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

import com.example.demo.dtos.AddToRoleDtos;
import com.example.demo.dtos.UserRequestDtos;
import com.example.demo.dtos.UserResponseDtos;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(value = "User APIs")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserResponseDtos> findAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(userService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@GetMapping("/role/{roleName}")
	public ResponseEntity<?> findByRole(@PathVariable String roleName){
		try {
			return ResponseEntity.ok(userService.findByRole(roleName));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody UserRequestDtos dtos) {
		try {
			return ResponseEntity.ok(userService.create(dtos));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody UserRequestDtos dtos) {
		try {
			return ResponseEntity.ok(userService.update(id, dtos));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@PostMapping("addrole")
	public String addrole(@RequestBody AddToRoleDtos dtos) {
		try {
			userService.AddUserRole(dtos);
			return "Add success!";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		try {
			userService.delete(id);
			return "Delete success!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
