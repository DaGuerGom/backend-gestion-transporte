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

import com.proyecto.dto.UsuarioRutaAutobusDTOIn;
import com.proyecto.dto.UsuarioRutaAutobusDTOOut;
import com.proyecto.services.UsuarioRutaAutobusService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioRutaAutobusController {
	
	@Autowired
	private UsuarioRutaAutobusService service;
	
	@GetMapping("/asignacionesBuses")
	public List<UsuarioRutaAutobusDTOOut> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/asignacionesBuses/{username}")
	public List<UsuarioRutaAutobusDTOOut> findWithUsername(@PathVariable String username){
		return this.service.findWithUsername(username);
	}
	
	@PostMapping("/asignacionesBuses")
	public UsuarioRutaAutobusDTOOut save(@RequestBody UsuarioRutaAutobusDTOIn relacion) {
		return this.service.save(relacion);
	}
	
	@DeleteMapping("/asignacionesBuses/{id}")
	public void delete(@PathVariable Long id) {
		this.service.delete(id);
	}
}
