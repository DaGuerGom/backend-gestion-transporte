package com.proyecto.dto;

public class UsuarioRutaParadaDTOIn {
	private String username;
	private Long ruta;
	private Long parada;
	public UsuarioRutaParadaDTOIn(String username, Long ruta, Long parada) {
		this.username = username;
		this.ruta = ruta;
		this.parada = parada;
	}
	public UsuarioRutaParadaDTOIn() {
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
	public Long getParada() {
		return parada;
	}
	public void setParada(Long parada) {
		this.parada = parada;
	}
	
	
}
