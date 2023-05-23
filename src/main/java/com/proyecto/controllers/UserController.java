package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.UserDTOIn;
import com.proyecto.dto.UserDTOOut;
import com.proyecto.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController{
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<UserDTOOut> getAllUsers(){
		return service.findAll();
	}

	@GetMapping("/users/{username}")
	public UserDTOOut getUserById(@PathVariable String username) {
		return this.service.findById(username);
	}
	
	@PostMapping("/users")
	public UserDTOOut saveUser(@RequestBody UserDTOIn user){
		return this.service.saveUser(user); 
	}
	
	@PutMapping("/users/{username}")
	public UserDTOOut updateUser(@PathVariable String username,@RequestBody UserDTOIn user) {
		return this.service.updateUser(username, user);
	}
	
	@DeleteMapping("/users/{username}")
	public void deleteUser(@PathVariable String username) {
		this.service.deleteUser(username);
	}
}