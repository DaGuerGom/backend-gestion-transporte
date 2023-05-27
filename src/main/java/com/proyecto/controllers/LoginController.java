package com.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.LoginDTO;
import com.proyecto.dto.UserDTOOut;
import com.proyecto.services.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<UserDTOOut> login(@RequestBody LoginDTO credentials){
		UserDTOOut usuario=this.service.validateUser(credentials);
		if (usuario!=null) {
			return new ResponseEntity<>(usuario,HttpStatus.OK);
		}
		return new ResponseEntity<>(usuario,HttpStatus.NOT_FOUND);
	}
}
