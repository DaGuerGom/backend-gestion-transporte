package com.proyecto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.dto.UsuarioRutaParadaDTOIn;
import com.proyecto.dto.UsuarioRutaParadaDTOOut;
import com.proyecto.models.Parada;
import com.proyecto.models.Ruta;
import com.proyecto.models.User;
import com.proyecto.models.UsuarioRutaParada;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UserRepository;

@Component
public class UsuarioRutaParadaConverter {
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RutaConverter rutaConverter;
	
	@Autowired
	private ParadaConverter paradaConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RutaRepository rutaRepository;
	
	@Autowired
	private ParadaRepository paradaRepository;
	
	public UsuarioRutaParadaDTOOut toDTO(UsuarioRutaParada entity) {
		return new UsuarioRutaParadaDTOOut(
				entity.getId(),
				this.userConverter.toDTO(entity.getUsuario()),
				this.rutaConverter.toDTO(entity.getRuta()),
				this.paradaConverter.toDTO(entity.getParada()));
	}
	
	public UsuarioRutaParada toEntity(UsuarioRutaParadaDTOIn dto) {
		User usuario=this.userRepository.findById(dto.getUsername()).orElse(null);
		Ruta ruta=this.rutaRepository.findById(dto.getRuta()).orElse(null);
		Parada parada=this.paradaRepository.findById(dto.getParada()).orElse(null);
		UsuarioRutaParada aDevolver= new UsuarioRutaParada();
		aDevolver.setUsuario(usuario);
		aDevolver.setRuta(ruta);
		aDevolver.setParada(parada);
		return aDevolver;
	}
}
