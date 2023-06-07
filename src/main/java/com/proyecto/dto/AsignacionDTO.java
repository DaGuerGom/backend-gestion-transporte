package com.proyecto.dto;

import java.util.List;

public class AsignacionDTO {
	private UsuarioRutaAutobusDTOOut asignacionBus;
	private Long idParada;
	private String parada;
	
	public AsignacionDTO(UsuarioRutaAutobusDTOOut asignacionBus, Long idParada, String parada) {
		this.asignacionBus = asignacionBus;
		this.idParada = idParada;
		this.parada = parada;
	}
	public AsignacionDTO() {
	}
	public UsuarioRutaAutobusDTOOut getAsignacionBus() {
		return asignacionBus;
	}
	public void setAsignacionBus(UsuarioRutaAutobusDTOOut asignacionBus) {
		this.asignacionBus = asignacionBus;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public Long getIdParada() {
		return idParada;
	}
	public void setIdParada(Long idParada) {
		this.idParada = idParada;
	}
	
}
