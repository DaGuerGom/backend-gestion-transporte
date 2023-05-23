package com.proyecto.dto;

import java.util.List;

//Datos que se enviaran desde un formulario al crear una ruta.
public class RutaDTOIn {
	private String nombre;
	private String horaSalida;
	private String horaLlegada;
	private List<String> usuarios;
	private List<Long> paradas;
	private List<Long> autobuses;
	public RutaDTOIn(String nombre, String horaSalida, String horaLlegada, List<String> usuarios, List<Long> paradas,
			List<Long> autobuses) {
		this.nombre = nombre;
		this.horaSalida = horaSalida;
		this.horaLlegada=horaLlegada;
		this.usuarios = usuarios;
		this.paradas = paradas;
		this.autobuses = autobuses;
	}
	
	public RutaDTOIn() {
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
