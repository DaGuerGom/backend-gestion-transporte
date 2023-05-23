package com.proyecto.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.dto.UserDTOIn;
import com.proyecto.dto.UserDTOOut;
import com.proyecto.models.Parada;
import com.proyecto.models.Ruta;
import com.proyecto.models.User;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.RutaRepository;

@Component
public class UserConverter {

	@Autowired
	private ParadaRepository paradaRepository;
	@Autowired
	private RutaRepository rutaRepository;
	
	public UserDTOOut toDTO(User user){
		List<Long> idParadas = new ArrayList<Long>();
		for (Parada p : user.getParadas()) {
			idParadas.add(p.getId());
		}
		List<Long> idRutas = new ArrayList<Long>();
		for (Ruta r : user.getRutas()) {
			idRutas.add(r.getId());
		}
		return new UserDTOOut(
				user.getUsername(),
				user.getEmail(),
				user.getTipo(),
				user.getAdmitido(),
				idRutas,
				idParadas
				);
	}
	
	public User toEntity(UserDTOIn user, char admitido) {
		User entity=new User();
		List<Parada> paradas = new ArrayList<Parada>();
		if (user.getParadas() != null) {
			paradas.addAll(this.paradaRepository.findAllById(user.getParadas()));
		}
		List<Ruta> rutas = new ArrayList<Ruta>();
		if (user.getRutas() != null) {
			rutas.addAll(this.rutaRepository.findAllById(user.getRutas()));
		}
		entity.setUsername(user.getUsername());
		entity.setPassword(user.getPassword());
		entity.setEmail(user.getEmail());
		entity.setAdmitido(admitido);
		entity.setRutas(rutas);
		entity.setParadas(paradas);
		entity.setTipo(user.getTipo());
		return entity;
	}
}
