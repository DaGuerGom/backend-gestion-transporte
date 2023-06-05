package com.proyecto.dto;

import java.util.ArrayList;

public class AutobusDTOIn {
	
	private String nombre;
	private int capacidad;
	private ArrayList<Long> idRutas=new ArrayList<Long>();
	
	public AutobusDTOIn(String nombre,int capacidad, ArrayList<Long> idRutas) {
		this.nombre=nombre;
		this.capacidad = capacidad;
		this.idRutas=idRutas;
	}

	public AutobusDTOIn() {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
