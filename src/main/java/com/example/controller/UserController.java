package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.dto.UserDto;
import com.example.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/user/{id}")
	public UserDto getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
}
