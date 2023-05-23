package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.converters.AutobusConverter;
import com.proyecto.dto.AutobusDTOIn;
import com.proyecto.dto.AutobusDTOOut;
import com.proyecto.models.Autobus;
import com.proyecto.models.Ruta;
import com.proyecto.repositories.AutobusRepository;
import com.proyecto.repositories.RutaRepository;

@Service
public class AutobusService {

	@Autowired
	private AutobusRepository busRepository;
	
	@Autowired
	private RutaRepository rutaRepository;
	
	private AutobusConverter converter=new AutobusConverter();
	
	public List<AutobusDTOOut> findAll() {
		List<Autobus> buses= this.busRepository.findAll();
		List<AutobusDTOOut> aDevolver=new ArrayList<AutobusDTOOut>();
		for(Autobus bus:buses) {
			aDevolver.add(this.converter.toDTO(bus));
		}
		return aDevolver;
	}

	public ResponseEntity<AutobusDTOOut> findById(Long id) {
		return ResponseEntity.ok(this.converter.toDTO(busRepository.findById(id).orElse(null)));
	}
	
	public AutobusDTOOut saveBus(AutobusDTOIn dBus) {
		Autobus bus=this.converter.toEntity(dBus,new ArrayList<Ruta>());//Las rutas del bus seran nulas cuando se cree
		busRepository.save(bus);
		return this.converter.toDTO(bus);
	}
	
	public void deleteBus(Long id) {
		this.busRepository.deleteById(id);
	}

	public ResponseEntity<AutobusDTOOut> updateBusById(Long id, AutobusDTOIn dBus) {
		Autobus bus=this.busRepository.findById(id).orElse(null);
		this.deleteBus(bus.getId());
		bus.setCapacidad(dBus.getCapacidad());
		ArrayList<Ruta> rutas=(ArrayList<Ruta>)this.rutaRepository.findAllById(dBus.getIdRutas());
		bus.setRutas(rutas);
		this.busRepository.save(bus);
		return ResponseEntity.ok(this.converter.toDTO(bus));
	}
}
