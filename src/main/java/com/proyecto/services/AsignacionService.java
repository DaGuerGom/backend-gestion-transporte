package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.UsuarioRutaAutobusConverter;
import com.proyecto.converters.UsuarioRutaParadaConverter;
import com.proyecto.dto.AsignacionDTO;
import com.proyecto.models.Parada;
import com.proyecto.models.UsuarioRutaAutobus;
import com.proyecto.models.UsuarioRutaParada;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.UsuarioRutaAutobusRepository;
import com.proyecto.repositories.UsuarioRutaParadaRepository;

@Service
public class AsignacionService {

	@Autowired
	private UsuarioRutaParadaRepository urpRepository;
	
	@Autowired
	private UsuarioRutaAutobusRepository uraRepository;
	
	@Autowired
	private UsuarioRutaParadaConverter urpConverter;
	
	@Autowired
	private UsuarioRutaAutobusConverter uraConverter;
	
	@Autowired
	private ParadaRepository paradaRepository;
	
	public List<AsignacionDTO> findAsignaciones(String username) {
		List<UsuarioRutaAutobus> asignacionesBus=this.uraRepository.findAll();
		List<AsignacionDTO> asignacionesAUsuario= new ArrayList<AsignacionDTO>();
		for(UsuarioRutaAutobus asignacion:asignacionesBus) {
			if(asignacion.getUsuario().getUsername().equalsIgnoreCase(username)) {
				asignacionesAUsuario.add(this.toAsignacionCompleta(asignacion));
			}
		}
		return asignacionesAUsuario;
	}

	
	/*
	 * Aqui vamos a añadir el id y nombre de la parada asignada.
	 * Para ello, recorremos los registros de la relacion ternaria entre
	 * Usuario-Ruta-Parada. Tanto esa relacion como Usuario-Ruta-Autobus
	 * tienen los campos username (PK de usuario) e id_ruta.
	 * Como desde el front se validara que estos dos campos no se repitan,
	 * por logica, cuando coinciden la combinacion en ambas relaciones,
	 * se refiere a la misma asignacion
	 * */
	private AsignacionDTO toAsignacionCompleta(UsuarioRutaAutobus asignacionBus) {
		AsignacionDTO aDevolver=new AsignacionDTO();
		aDevolver.setAsignacionBus(this.uraConverter.toDTO(asignacionBus));
		List<UsuarioRutaParada> asignacionesParadas=this.urpRepository.findAll();
		for(Long idParada:aDevolver.getAsignacionBus().getRuta().getParadas()) {
			for(UsuarioRutaParada asignacion:asignacionesParadas) {
				if (asignacion.getUsuario().getUsername().equals(asignacionBus.getUsuario().getUsername()) && 
						asignacion.getRuta().getId()==asignacionBus.getRuta().getId()) {
					aDevolver.setIdParada(idParada);
					aDevolver.setParada(this.paradaRepository.findById(idParada).orElse(null).getNombre());
				}
			}
		}
		return aDevolver;
	}
}
