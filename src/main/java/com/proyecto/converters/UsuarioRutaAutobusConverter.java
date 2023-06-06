package com.proyecto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.dto.UsuarioRutaAutobusDTOIn;
import com.proyecto.dto.UsuarioRutaAutobusDTOOut;
import com.proyecto.models.Autobus;
import com.proyecto.models.Ruta;
import com.proyecto.models.User;
import com.proyecto.models.UsuarioRutaAutobus;
import com.proyecto.repositories.AutobusRepository;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UserRepository;

@Component
public class UsuarioRutaAutobusConverter {
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RutaConverter rutaConverter;
	
	@Autowired
	private AutobusConverter autobusConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RutaRepository rutaRepository;
	
	@Autowired
	private AutobusRepository autobusRepository;
	
	public UsuarioRutaAutobusDTOOut toDTO(UsuarioRutaAutobus entity) {
		return new UsuarioRutaAutobusDTOOut(
				entity.getId(),
				this.userConverter.toDTO(entity.getUsuario()),
				this.rutaConverter.toDTO(entity.getRuta()),
				this.autobusConverter.toDTO(entity.getAutobus()));
	}
	
	public UsuarioRutaAutobus toEntity(UsuarioRutaAutobusDTOIn dto) {
		User usuario=this.userRepository.findById(dto.getUsername()).orElse(null);
		Ruta ruta=this.rutaRepository.findById(dto.getRuta()).orElse(null);
		Autobus autobus=this.autobusRepository.findById(dto.getAutobus()).orElse(null);
		UsuarioRutaAutobus aDevolver= new UsuarioRutaAutobus();
		aDevolver.setUsuario(usuario);
		aDevolver.setRuta(ruta);
		aDevolver.setAutobus(autobus);
		return aDevolver;
	}
}
