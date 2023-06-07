package com.proyecto.dto;

import java.util.List;
import java.util.Objects;

public class RutaDTOOut {

	private Long id;
	private String nombre;
	private String horaSalida;
	private String horaLlegada;
	private List<String> usuarios;
	private List<Long> paradas;
	private List<Long> autobuses;
	private List<String> nombresParadas;
	private List<String> nombresAutobuses;
	
	public RutaDTOOut(Long id, String nombre, String horaSalida, String horaLlegada, List<String> usuarios,
			List<Long> paradas, List<Long> autobuses, List<String> nombresParadas, List<String> nombresAutobuses) {
		this.id = id;
		this.nombre = nombre;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.usuarios = usuarios;
		this.paradas = paradas;
		this.autobuses = autobuses;
		this.nombresParadas = nombresParadas;
		this.nombresAutobuses = nombresAutobuses;
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

	public List<String> getNombresParadas() {
		return nombresParadas;
	}

	public void setNombresParadas(List<String> nombresParadas) {
		this.nombresParadas = nombresParadas;
	}

	public List<String> getNombresAutobuses() {
		return nombresAutobuses;
	}

	public void setNombresAutobuses(List<String> nombresAutobuses) {
		this.nombresAutobuses = nombresAutobuses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RutaDTOOut other = (RutaDTOOut) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
