package com.proyecto.dto;

import java.util.ArrayList;

public class AutobusDTOOut {
	
	private Long id;
	private String nombre;
	private int capacidad;
	private ArrayList<Long> idRutas=new ArrayList<Long>();
	
	public AutobusDTOOut(Long id,String nombre, int capacidad, ArrayList<Long> idRutas) {
		this.id = id;
		this.nombre=nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
