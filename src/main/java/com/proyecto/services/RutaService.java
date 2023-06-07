package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.RutaConverter;
import com.proyecto.dto.RutaDTOIn;
import com.proyecto.dto.RutaDTOOut;
import com.proyecto.dto.UsuarioRutaAutobusDTOOut;
import com.proyecto.models.Autobus;
import com.proyecto.models.Ruta;
import com.proyecto.models.UsuarioRutaAutobus;
import com.proyecto.repositories.AutobusRepository;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UserRepository;
import com.proyecto.repositories.UsuarioRutaAutobusRepository;

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
	@Autowired
	private UsuarioRutaAutobusRepository uraRepository;
	
	public List<RutaDTOOut> findAll() {
		List<RutaDTOOut> aDevolver=new ArrayList<RutaDTOOut>();
		for(Ruta r:this.rutaRepository.findAll()) {
			aDevolver.add(this.converter.toDTO(r));
		}
		return aDevolver;
	}

	public List<RutaDTOOut> getRutasDisponibles(){
		List <UsuarioRutaAutobus> relaciones=this.uraRepository.findAll();
		List<RutaDTOOut> aDevolver=new ArrayList<RutaDTOOut>();
		for (Ruta r:this.rutaRepository.findAll()) {
			for (Autobus a:r.getAutobuses()) {
				int capacidadActual=0;
				//Lista auxiliar de asignaciones que se añadiran luego a la lista a devolver en funcion de la capacidad del autobus
				List <UsuarioRutaAutobus> aux= new ArrayList <UsuarioRutaAutobus>();
				for(UsuarioRutaAutobus relacion:relaciones) {
					if(relacion.getRuta().getId()==r.getId() && relacion.getAutobus().getId()==a.getId()) {
						capacidadActual++;
						aux.add(relacion);
					}
				}
				if (capacidadActual<a.getCapacidad()) {
					for(UsuarioRutaAutobus ura:aux) {
						RutaDTOOut rutaDTO=this.converter.toDTO(ura.getRuta());
						if(!aDevolver.contains(rutaDTO)) {
							aDevolver.add(rutaDTO);						
						}
					}
				}
			}
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
