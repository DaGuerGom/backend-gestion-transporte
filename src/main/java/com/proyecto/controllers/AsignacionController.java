package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.AsignacionDTO;
import com.proyecto.services.AsignacionService;

@RestController
@RequestMapping("/api/v1")
public class AsignacionController {
	@Autowired
	private AsignacionService service;
	
	@GetMapping("/misRutas/{username}")
	public List<AsignacionDTO> findAsignaciones(@PathVariable String username) {
		return this.service.findAsignaciones(username);
	}
}
