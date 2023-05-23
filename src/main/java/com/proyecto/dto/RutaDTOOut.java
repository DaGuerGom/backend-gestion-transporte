package com.proyecto.dto;

import java.util.List;

public class RutaDTOOut {

	private Long id;
	private String nombre;
	private String horaSalida;
	private String horaLlegada;
	private List<String> usuarios;
	private List<Long> paradas;
	private List<Long> autobuses;
	public RutaDTOOut(Long id, String nombre, String horaSalida, String horaLlegada, List<String> usuarios, List<Long> paradas,
			List<Long> autobuses) {
		this.id = id;
		this.nombre = nombre;
		this.horaSalida = horaSalida;
		this.horaLlegada=horaLlegada;
		this.usuarios = usuarios;
		this.paradas = paradas;
		this.autobuses = autobuses;
	}
	
	public RutaDTOOut() {
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
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public List<String> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<String> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Long> getParadas() {
		return paradas;
	}
	public void setParadas(List<Long> paradas) {
		this.paradas = paradas;
	}
	public List<Long> getAutobuses() {
		return autobuses;
	}
	public void setAutobuses(List<Long> autobuses) {
		this.autobuses = autobuses;
	}
	
	
}
