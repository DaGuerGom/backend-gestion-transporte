package com.proyecto.dto;

import java.util.List;

public class ParadaDTOIn {
	private String nombre;
	private List<Long> rutas;
	private List<String> usuarios;
	
	public ParadaDTOIn(String nombre, List<Long> rutas, List<String> usuarios) {
		this.nombre = nombre;
		this.rutas = rutas;
		this.usuarios = usuarios;
	}
	
	public ParadaDTOIn() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Long> getRutas() {
		return rutas;
	}
	public void setRutas(List<Long> rutas) {
		this.rutas = rutas;
	}
	public List<String> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<String> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
