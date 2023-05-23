package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.RutaConverter;
import com.proyecto.dto.RutaDTOIn;
import com.proyecto.dto.RutaDTOOut;
import com.proyecto.models.Ruta;
import com.proyecto.repositories.AutobusRepository;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UserRepository;

@Service
public class RutaService {

	@Autowired
	private RutaRepository rutaRepository;
	@Autowired
	private UserRepository usuarioRepository;
	@Autowired
	private AutobusRepository autobusRepository;
	@Autowired
	private ParadaRepository paradaRepository;
	@Autowired
	private RutaConverter converter;
	
	public List<RutaDTOOut> findAll() {
		List<RutaDTOOut> aDevolver=new ArrayList<RutaDTOOut>();
		for(Ruta r:this.rutaRepository.findAll()) {
			aDevolver.add(this.converter.toDTO(r));
		}
		return aDevolver;
	}

	public RutaDTOOut saveRuta(RutaDTOIn ruta) {
		return this.converter.toDTO(this.rutaRepository.save(this.converter.toEntity(ruta)));
	}
	
	public RutaDTOOut findById(Long id) {
		return this.converter.toDTO(rutaRepository.findById(id).orElse(null));
	}

	public RutaDTOOut update(Long id, RutaDTOIn rutaDTO) {
		Ruta ruta=this.rutaRepository.findById(id).orElse(null);
		this.rutaRepository.delete(ruta);
		ruta.setNombre(rutaDTO.getNombre());
		ruta.setHoraSalida(rutaDTO.getHoraSalida());
		ruta.setHoraLlegada(rutaDTO.getHoraLlegada());
		ruta.setAutobuses(this.autobusRepository.findAllById(rutaDTO.getAutobuses()));
		ruta.setUsuarios(this.usuarioRepository.findAllById(rutaDTO.getUsuarios()));
		ruta.setParadas(this.paradaRepository.findAllById(rutaDTO.getParadas()));
		this.rutaRepository.save(ruta);
		return this.converter.toDTO(ruta);
	}

	public void delete(Long id) {
		this.rutaRepository.deleteById(id);
	}
}
