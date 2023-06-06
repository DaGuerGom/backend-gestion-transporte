package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.UsuarioRutaAutobusConverter;
import com.proyecto.dto.UsuarioRutaAutobusDTOIn;
import com.proyecto.dto.UsuarioRutaAutobusDTOOut;
import com.proyecto.models.UsuarioRutaAutobus;
import com.proyecto.repositories.UsuarioRutaAutobusRepository;

@Service
public class UsuarioRutaAutobusService {

	@Autowired
	private UsuarioRutaAutobusConverter converter;
	
	@Autowired
	private UsuarioRutaAutobusRepository repository;
	
	public List<UsuarioRutaAutobusDTOOut> findAll() {
		List<UsuarioRutaAutobus> relaciones=this.repository.findAll();
		List<UsuarioRutaAutobusDTOOut> aDevolver=new ArrayList<UsuarioRutaAutobusDTOOut>();
		for(UsuarioRutaAutobus relacion:relaciones) {
			aDevolver.add(this.converter.toDTO(relacion));
		}
		return aDevolver;
	}

	public List<UsuarioRutaAutobusDTOOut> findWithUsername(String username) {
		List<UsuarioRutaAutobus> relaciones=this.repository.findAll();
		List<UsuarioRutaAutobusDTOOut> aDevolver=new ArrayList<UsuarioRutaAutobusDTOOut>();
		for(UsuarioRutaAutobus relacion:relaciones) {
			if(relacion.getUsuario().getUsername().equalsIgnoreCase(username)) {
				aDevolver.add(this.converter.toDTO(relacion));
			}
		}
		return aDevolver;
	}
	
	public UsuarioRutaAutobusDTOOut save(UsuarioRutaAutobusDTOIn relacion) {
		return this.converter.toDTO(this.repository.save(this.converter.toEntity(relacion)));
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
