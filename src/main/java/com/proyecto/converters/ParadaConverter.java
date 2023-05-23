package com.proyecto.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.dto.ParadaDTOIn;
import com.proyecto.dto.ParadaDTOOut;
import com.proyecto.models.Parada;
import com.proyecto.models.Ruta;
import com.proyecto.models.User;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UserRepository;

@Component
public class ParadaConverter {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RutaRepository rutaRepository;
	
	public ParadaDTOOut toDTO(Parada parada) {
		List<String> idUsuarios = new ArrayList<String>();
		for (User u : parada.getUsuarios()) {
			idUsuarios.add(u.getUsername());
		}
		List<Long> idRutas = new ArrayList<Long>();
		for (Ruta r : parada.getRutas()) {
			idRutas.add(r.getId());
		}
		return new ParadaDTOOut(
				parada.getId(),
				parada.getNombre(),
				idRutas,
				idUsuarios
				);
	}
	
	public Parada toEntity(ParadaDTOIn parada) {
		List<Ruta> rutas = new ArrayList<Ruta>();
		if (parada.getRutas() != null) {
			rutas.addAll(this.rutaRepository.findAllById(parada.getRutas()));
		}
		List<User> usuarios = new ArrayList<User>();
		if (parada.getUsuarios() != null) {
			usuarios.addAll(this.userRepository.findAllById(parada.getUsuarios()));
		}
		Parada aDevolver=new Parada();
		aDevolver.setNombre(parada.getNombre());
		aDevolver.setRutas(rutas);
		aDevolver.setUsuarios(usuarios);
		return aDevolver;
	}
	
}
