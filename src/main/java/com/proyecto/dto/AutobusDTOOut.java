package com.proyecto.dto;

import java.util.ArrayList;

public class AutobusDTOOut {
	
	private Long id;
	private int capacidad;
	private ArrayList<Long> idRutas=new ArrayList<Long>();
	
	public AutobusDTOOut(Long id, int capacidad, ArrayList<Long> idRutas) {
		this.id = id;
		this.capacidad = capacidad;
		this.idRutas = idRutas;
	}

	public AutobusDTOOut() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public ArrayList<Long> getIdRutas() {
		return idRutas;
	}

	public void setIdRutas(ArrayList<Long> idRutas) {
		this.idRutas = idRutas;
	}
	
	
}
