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

import com.proyecto.dto.AutobusDTOOut;
import com.proyecto.dto.ParadaDTOIn;
import com.proyecto.dto.ParadaDTOOut;
import com.proyecto.dto.UserDTOIn;
import com.proyecto.dto.UserDTOOut;
import com.proyecto.services.ParadaService;

@RestController
@RequestMapping("/api/v1/")
public class ParadaController {
	
	@Autowired
	private ParadaService service;
	
	@GetMapping("/paradas")
	public List<ParadaDTOOut> getAllParadas(){
		return service.findAll();
	}
	@GetMapping("/paradasDeRuta/{idRuta}")
	public List<ParadaDTOOut> getParadasDeRuta(@PathVariable Long idRuta){
		return this.service.getParadasDeRuta(idRuta);
	}
	
	@GetMapping("/paradas/{id}")
	public ParadaDTOOut getParadaById(@PathVariable Long id) {
		return this.service.getParadaById(id);
	}
	
	@PostMapping("/paradas")
	public ParadaDTOOut saveParada(@RequestBody ParadaDTOIn parada) {
		return this.service.save(parada);
	}
	
	@PutMapping("/paradas/{id}")
	public ParadaDTOOut updateUser(@PathVariable Long id,@RequestBody ParadaDTOIn parada) {
		return this.service.update(id, parada);
	}
	
	@DeleteMapping("/paradas/{id}")
	public void deleteUser(@PathVariable Long id) {
		this.service.delete(id);
	}
}
