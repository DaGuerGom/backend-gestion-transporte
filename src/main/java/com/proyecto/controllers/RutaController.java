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

import com.proyecto.dto.RutaDTOIn;
import com.proyecto.dto.RutaDTOOut;
import com.proyecto.dto.UsuarioRutaAutobusDTOOut;
import com.proyecto.services.RutaService;

@RestController
@RequestMapping("/api/v1")
public class RutaController{
	
	@Autowired
	private RutaService service;
	
	@GetMapping("/routes")
	public List<RutaDTOOut> getAllRutas(){
		return service.findAll();
	}
	
	@GetMapping("/rutasDisponibles")
	public List<RutaDTOOut> getRutasDisponibles(){
		return this.service.getRutasDisponibles();
	}
	
	@GetMapping("/routes/{id}")
	public RutaDTOOut findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@PostMapping("/routes")
	public RutaDTOOut saveRuta(@RequestBody RutaDTOIn ruta){
		return service.saveRuta(ruta); 
	}
	
	@PutMapping("/routes/{id}")
	public RutaDTOOut updateRuta(@PathVariable Long id,@RequestBody RutaDTOIn ruta) {
		return this.service.update(id,ruta);
	}
	
	@DeleteMapping("/routes/{id}")
	public void deleteRuta(@PathVariable Long id) {
		this.service.delete(id);
	}
}