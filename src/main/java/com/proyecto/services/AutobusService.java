package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.converters.AutobusConverter;
import com.proyecto.dto.AutobusDTOIn;
import com.proyecto.dto.AutobusDTOOut;
import com.proyecto.dto.UsuarioRutaAutobusDTOOut;
import com.proyecto.models.Autobus;
import com.proyecto.models.Ruta;
import com.proyecto.repositories.AutobusRepository;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UsuarioRutaAutobusRepository;

@Service
public class AutobusService {

	@Autowired
	private AutobusRepository busRepository;
	
	@Autowired
	private RutaRepository rutaRepository;
	
	private AutobusConverter converter=new AutobusConverter();
	
	@Autowired
	private UsuarioRutaAutobusService uraService;
	
	public List<AutobusDTOOut> findAll() {
		List<Autobus> buses= this.busRepository.findAll();
		List<AutobusDTOOut> aDevolver=new ArrayList<AutobusDTOOut>();
		for(Autobus bus:buses) {
			aDevolver.add(this.converter.toDTO(bus));
		}
		return aDevolver;
	}

	public ResponseEntity<AutobusDTOOut> findById(Long id) {
		return ResponseEntity.ok(this.converter.toDTO(busRepository.findById(id).orElse(null)));
	}
	
	public AutobusDTOOut saveBus(AutobusDTOIn dBus) {
		Autobus bus=this.converter.toEntity(dBus,new ArrayList<Ruta>());//Las rutas del bus seran nulas cuando se cree
		busRepository.save(bus);
		return this.converter.toDTO(bus);
	}
	
	public void deleteBus(Long id) {
		this.busRepository.deleteById(id);
	}

	public ResponseEntity<AutobusDTOOut> updateBusById(Long id, AutobusDTOIn dBus) {
		Autobus bus=this.busRepository.findById(id).orElse(null);
		bus.setNombre(dBus.getNombre());
		bus.setCapacidad(dBus.getCapacidad());
		List<Ruta> rutas=this.rutaRepository.findAllById(dBus.getIdRutas());
		bus.setRutas(rutas);
		this.busRepository.save(bus);
		return ResponseEntity.ok(this.converter.toDTO(bus));
	}

	public List<AutobusDTOOut> getFreeBuses() {
		List<AutobusDTOOut> aDevolver=new ArrayList<AutobusDTOOut>();
		for(Autobus autobus:this.busRepository.findAll()) {
			if(autobus.getRutas().size()<2) {
				aDevolver.add(this.converter.toDTO(autobus));
			}
		}
		return aDevolver;
		
	}

	public List<AutobusDTOOut> getBusesDeRuta(Long idRuta) {
		List<AutobusDTOOut> aDevolver= new ArrayList<AutobusDTOOut>();
		List<AutobusDTOOut> buses=this.findAll();
		for(AutobusDTOOut bus:buses) {
			if(bus.getIdRutas().contains(idRuta)) {
				aDevolver.add(bus);
			}
		}
		return aDevolver;
	}

	public List<AutobusDTOOut> getBusesDeRutaSinOcupar(Long idRuta) {
		List<AutobusDTOOut> aDevolver=new ArrayList<AutobusDTOOut>();
		List<AutobusDTOOut> busesDeRuta=this.getBusesDeRuta(idRuta);
		List<UsuarioRutaAutobusDTOOut> asignaciones=this.uraService.getAsignacionesDeRuta(idRuta);
			for(AutobusDTOOut autobus:busesDeRuta) {
				int capacidadActual=0;
				//Revisamos las veces que aparece el autobus con la ruta en la asignacion (relacion ternaria).
				//Por cada asignacion, habra un usuario apuntado.
				for(UsuarioRutaAutobusDTOOut asignacion:asignaciones) {
					if(autobus.getId()==asignacion.getAutobus().getId()) {
						capacidadActual++;
					}
				}
				if (capacidadActual<autobus.getCapacidad()) {
					aDevolver.add(autobus);
				}
			}
		return aDevolver;
	}
}
