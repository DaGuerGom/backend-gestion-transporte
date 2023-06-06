package com.proyecto.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.dto.RutaDTOIn;
import com.proyecto.dto.RutaDTOOut;
import com.proyecto.models.Autobus;
import com.proyecto.models.Parada;
import com.proyecto.models.Ruta;
import com.proyecto.models.User;
import com.proyecto.repositories.AutobusRepository;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.UserRepository;

@Component
public class RutaConverter {

	private AutobusRepository autobusRepository;
    private UserRepository usuarioRepository;
    private ParadaRepository paradaRepository;

    @Autowired
    public RutaConverter(AutobusRepository autobusRepository, UserRepository usuarioRepository, ParadaRepository paradaRepository) {
        this.autobusRepository = autobusRepository;
        this.usuarioRepository = usuarioRepository;
        this.paradaRepository = paradaRepository;
    }
	
	public RutaDTOOut toDTO(Ruta ruta) {
		List<Long> idBuses = new ArrayList<Long>();
		List<String> nombresBuses = new ArrayList<String>();
		for (Autobus a : ruta.getAutobuses()) {
			idBuses.add(a.getId());
			nombresBuses.add(a.getNombre());
		}
		List<String> idUsuarios = new ArrayList<String>();
		for (User u : ruta.getUsuarios()) {
			idUsuarios.add(u.getUsername());
		}
		List<Long> idParadas = new ArrayList<Long>();
		List<String> nombresParadas = new ArrayList<String>();
		for (Parada p : ruta.getParadas()) {
			idParadas.add(p.getId());
			nombresParadas.add(p.getNombre());
		}
		return new RutaDTOOut(
				ruta.getId(),
				ruta.getNombre(),
				ruta.getHoraSalida(),
				ruta.getHoraLlegada(),
				idUsuarios,
				idParadas,
				idBuses,
				nombresParadas,
				nombresBuses
		);
	}
	
	public Ruta toEntity(RutaDTOIn ruta) {
		List<Autobus> autobuses = new ArrayList<Autobus>();
		if (ruta.getAutobuses() != null) {
			autobuses.addAll(this.autobusRepository.findAllById(ruta.getAutobuses()));
		}
		List<User> usuarios = new ArrayList<User>();
		if (ruta.getUsuarios() != null) {
			usuarios.addAll(this.usuarioRepository.findAllById(ruta.getUsuarios()));
		}
		
		List<Parada> paradas = new ArrayList<Parada>();
		if (ruta.getParadas() != null) {
			paradas.addAll(this.paradaRepository.findAllById(ruta.getParadas()));
		}
		
		Ruta aDevolver = new Ruta();
		aDevolver.setNombre(ruta.getNombre());
		aDevolver.setHoraSalida(ruta.getHoraSalida());
		aDevolver.setHoraLlegada(ruta.getHoraLlegada());
		aDevolver.setAutobuses(autobuses);
		aDevolver.setUsuarios(usuarios);
		aDevolver.setParadas(paradas);
		return aDevolver;
	}
}
