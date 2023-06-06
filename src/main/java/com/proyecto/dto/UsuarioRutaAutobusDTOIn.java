package com.proyecto.dto;

public class UsuarioRutaAutobusDTOIn {
	private String username;
	private Long ruta;
	private Long autobus;
	public UsuarioRutaAutobusDTOIn(String username, Long ruta, Long autobus) {
		this.username = username;
		this.ruta = ruta;
		this.autobus = autobus;
	}
	public UsuarioRutaAutobusDTOIn() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getRuta() {
		return ruta;
	}
	public void setRuta(Long ruta) {
		this.ruta = ruta;
	}
	public Long getAutobus() {
		return autobus;
	}
	public void setAutobus(Long autobus) {
		this.autobus = autobus;
	}
	
	
}
