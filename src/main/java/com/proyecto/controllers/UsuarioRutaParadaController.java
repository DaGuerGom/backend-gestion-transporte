package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.UsuarioRutaParadaDTOIn;
import com.proyecto.dto.UsuarioRutaParadaDTOOut;
import com.proyecto.services.UsuarioRutaParadaService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioRutaParadaController {
	
	@Autowired
	private UsuarioRutaParadaService service;
	
	@GetMapping("/asignacionesParadas")
	public List<UsuarioRutaParadaDTOOut> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/asignacionesParadas/{username}")
	public List<UsuarioRutaParadaDTOOut> findWithUsername(@PathVariable String username){
		return this.service.findWithUsername(username);
	}
	
	@PostMapping("/asignacionesParadas")
	public UsuarioRutaParadaDTOOut save(@RequestBody UsuarioRutaParadaDTOIn relacion) {
		return this.service.save(relacion);
	}
	
	@DeleteMapping("/asignacionesParadas/{id}")
	public void delete(@PathVariable Long id) {
		this.service.delete(id);
	}
}
