package com.proyecto.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.UsuarioRutaAutobusConverter;
import com.proyecto.dto.UsuarioRutaAutobusDTOIn;
import com.proyecto.dto.UsuarioRutaAutobusDTOOut;
import com.proyecto.models.Autobus;
import com.proyecto.models.Ruta;
import com.proyecto.models.UsuarioRutaAutobus;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UsuarioRutaAutobusRepository;

@Service
public class UsuarioRutaAutobusService {

	@Autowired
	private UsuarioRutaAutobusConverter converter;
	
	@Autowired
	private UsuarioRutaAutobusRepository uraRepository;
	
	@Autowired
	private RutaRepository rutaRepository;
	
	public List<UsuarioRutaAutobusDTOOut> findAll() {
		List<UsuarioRutaAutobus> relaciones=this.uraRepository.findAll();
		List<UsuarioRutaAutobusDTOOut> aDevolver=new ArrayList<UsuarioRutaAutobusDTOOut>();
		for(UsuarioRutaAutobus relacion:relaciones) {
			aDevolver.add(this.converter.toDTO(relacion));
		}
		return aDevolver;
	}
	
	public List<UsuarioRutaAutobusDTOOut> findWithUsername(String username) {
		List<UsuarioRutaAutobus> relaciones=this.uraRepository.findAll();
		List<UsuarioRutaAutobusDTOOut> aDevolver=new ArrayList<UsuarioRutaAutobusDTOOut>();
		for(UsuarioRutaAutobus relacion:relaciones) {
			if(relacion.getUsuario().getUsername().equalsIgnoreCase(username)) {
				aDevolver.add(this.converter.toDTO(relacion));
			}
		}
		return aDevolver;
	}
	
	public UsuarioRutaAutobusDTOOut save(UsuarioRutaAutobusDTOIn relacion) {
		return this.converter.toDTO(this.uraRepository.save(this.converter.toEntity(relacion)));
	}
	
	public void delete(Long id) {
		this.uraRepository.deleteById(id);
	}

	public List<UsuarioRutaAutobusDTOOut> getAsignacionesDeRuta(Long idRuta) {
		List<UsuarioRutaAutobusDTOOut> asignaciones=this.findAll();
		List<UsuarioRutaAutobusDTOOut> aDevolver=new ArrayList<UsuarioRutaAutobusDTOOut>();
		for(UsuarioRutaAutobusDTOOut asignacion:asignaciones) {
			if(asignacion.getRuta().getId()==idRuta) {
				aDevolver.add(asignacion);
			}
		}
		return aDevolver;
	}
}
