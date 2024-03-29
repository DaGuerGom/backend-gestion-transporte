package com.proyecto.controllers;

import java.util.List;

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

import com.proyecto.dto.AutobusDTOIn;
import com.proyecto.dto.AutobusDTOOut;
import com.proyecto.services.AutobusService;

@RestController
@RequestMapping("/api/v1/")
public class AutobusController {
	
	@Autowired
	private AutobusService service;
	
	@GetMapping("/bus")
	public List<AutobusDTOOut> getAllBus(){
		return this.service.findAll();
	}
	
	@GetMapping("/busesDeRuta/{idRuta}")
	public List<AutobusDTOOut> getBusesDeRuta(@PathVariable Long idRuta){
		return this.service.getBusesDeRuta(idRuta);
	}
	
	@GetMapping("/busesDeRuta/{idRuta}/sinOcupar")
	public List<AutobusDTOOut> getBusesDeRutaSinOcupar(@PathVariable Long idRuta){
		return this.service.getBusesDeRutaSinOcupar(idRuta);
	}
	
	@GetMapping("/busLibre")
	public List<AutobusDTOOut> getFreeBuses(){
		return this.service.getFreeBuses();
	}
	
	@GetMapping("/bus/{id}")
	public ResponseEntity<AutobusDTOOut> findBusById(@PathVariable Long id){
		return this.service.findById(id);
	}
	
	@PostMapping("/bus")
	public AutobusDTOOut saveBus(@RequestBody AutobusDTOIn dBus) {
		return this.service.saveBus(dBus);
	}
	
	@PutMapping("/bus/{id}")
	public ResponseEntity<AutobusDTOOut> updateBus(@PathVariable Long id, @RequestBody AutobusDTOIn dBus){
		return this.service.updateBusById(id,dBus);
	}
	
	@DeleteMapping("/bus/{id}")
	public void deleteBus(@PathVariable Long id){
		this.service.deleteBus(id);
	}
}
