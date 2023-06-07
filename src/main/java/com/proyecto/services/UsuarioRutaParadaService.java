package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.UsuarioRutaParadaConverter;
import com.proyecto.dto.UsuarioRutaParadaDTOIn;
import com.proyecto.dto.UsuarioRutaParadaDTOOut;
import com.proyecto.models.UsuarioRutaParada;
import com.proyecto.repositories.UsuarioRutaParadaRepository;

@Service
public class UsuarioRutaParadaService {

	@Autowired
	private UsuarioRutaParadaConverter converter;
	
	@Autowired
	private UsuarioRutaParadaRepository repository;
	
	public List<UsuarioRutaParadaDTOOut> findAll() {
		List<UsuarioRutaParada> relaciones=this.repository.findAll();
		List<UsuarioRutaParadaDTOOut> aDevolver=new ArrayList<UsuarioRutaParadaDTOOut>();
		for(UsuarioRutaParada relacion:relaciones) {
			aDevolver.add(this.converter.toDTO(relacion));
		}
		return aDevolver;
	}

	public List<UsuarioRutaParadaDTOOut> findWithUsername(String username) {
		List<UsuarioRutaParada> relaciones=this.repository.findAll();
		List<UsuarioRutaParadaDTOOut> aDevolver=new ArrayList<UsuarioRutaParadaDTOOut>();
		for(UsuarioRutaParada relacion:relaciones) {
			if(relacion.getUsuario().getUsername().equalsIgnoreCase(username)) {
				aDevolver.add(this.converter.toDTO(relacion));
			}
		}
		return aDevolver;
	}
	
	public UsuarioRutaParadaDTOOut save(UsuarioRutaParadaDTOIn relacion) {
		return this.converter.toDTO(this.repository.save(this.converter.toEntity(relacion)));
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	public List<UsuarioRutaParadaDTOOut> getAsignacionesDeRuta(Long idRuta) {
		List<UsuarioRutaParadaDTOOut> relaciones=this.findAll();
		List<UsuarioRutaParadaDTOOut> aDevolver=new ArrayList<UsuarioRutaParadaDTOOut>();
		for(UsuarioRutaParadaDTOOut relacion:relaciones) {
			if(relacion.getRuta().getId()==idRuta) {
				aDevolver.add(relacion);
			}
		}
		return aDevolver;
	}
}
