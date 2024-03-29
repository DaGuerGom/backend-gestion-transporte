package com.proyecto.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.dto.AutobusDTOIn;
import com.proyecto.dto.AutobusDTOOut;
import com.proyecto.models.Autobus;
import com.proyecto.models.Ruta;

@Component
public class AutobusConverter {
	
	public AutobusDTOOut toDTO(Autobus bus) {
			AutobusDTOOut aDevolver=new AutobusDTOOut();
			aDevolver.setId(bus.getId());
			aDevolver.setNombre(bus.getNombre());
			aDevolver.setCapacidad(bus.getCapacidad());
			aDevolver.setIdRutas(new ArrayList<Long>());
			for(Ruta r:bus.getRutas()) {
				aDevolver.getIdRutas().add(r.getId());
			}
			return aDevolver;
	}
	public Autobus toEntity(AutobusDTOIn bus, List<Ruta> rutas) {
		Autobus aDevolver= new Autobus();
		aDevolver.setNombre(bus.getNombre());
		aDevolver.setCapacidad(bus.getCapacidad());
		aDevolver.setRutas(rutas);
		return aDevolver;
	}
}
