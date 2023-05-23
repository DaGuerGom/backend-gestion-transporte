package com.proyecto.dto;

import java.util.List;

public class ParadaDTOOut {
	private Long id;
	private String nombre;
	private List<Long> rutas;
	private List<String> usuarios;
	
	public ParadaDTOOut(Long id, String nombre, List<Long> rutas, List<String> usuarios) {
		this.id = id;
		this.nombre = nombre;
		this.rutas = rutas;
		this.usuarios = usuarios;
	}
	
	public ParadaDTOOut() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
