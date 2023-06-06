package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.ParadaConverter;
import com.proyecto.dto.ParadaDTOIn;
import com.proyecto.dto.ParadaDTOOut;
import com.proyecto.models.Parada;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ParadaService {
	@Autowired
	private ParadaRepository paradaRepository;
	@Autowired
	private RutaRepository rutaRepository;
	@Autowired
	private UserRepository usuarioRepository;
	@Autowired
	private ParadaConverter converter;
	
	public List<ParadaDTOOut> findAll(){
		List<ParadaDTOOut> aDevolver=new ArrayList<ParadaDTOOut>();
		for(Parada p:this.paradaRepository.findAll()) {
			aDevolver.add(this.converter.toDTO(p));
		}
		return aDevolver;
	}

	public ParadaDTOOut getParadaById(Long id) {
		return this.converter.toDTO(this.paradaRepository.findById(id).orElse(null));
	}
	
	public ParadaDTOOut save(ParadaDTOIn parada) {
		return this.converter.toDTO(this.paradaRepository.save(this.converter.toEntity(parada)));
	}
	
	public ParadaDTOOut update(Long id, ParadaDTOIn parada) {
		Parada entity=this.paradaRepository.findById(id).orElse(null);
		entity.setNombre(parada.getNombre());
		entity.setRutas(this.rutaRepository.findAllById(parada.getRutas()));
		entity.setUsuarios(this.usuarioRepository.findAllById(parada.getUsuarios()));
		this.paradaRepository.save(entity);
		return this.converter.toDTO(entity);
	}
	
	public void delete(Long id) {
		this.paradaRepository.deleteById(id);
	}
}
