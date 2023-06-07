package com.proyecto.dto;

public class UsuarioRutaParadaDTOOut {
	private Long id;
	private UserDTOOut usuario;
	private RutaDTOOut ruta;
	private ParadaDTOOut parada;
	public UsuarioRutaParadaDTOOut(Long id, UserDTOOut usuario, RutaDTOOut ruta, ParadaDTOOut parada) {
		this.id = id;
		this.usuario = usuario;
		this.ruta = ruta;
		this.parada = parada;
	}
	public UsuarioRutaParadaDTOOut() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDTOOut getUsuario() {
		return usuario;
	}
	public void setUsuario(UserDTOOut usuario) {
		this.usuario = usuario;
	}
	public RutaDTOOut getRuta() {
		return ruta;
	}
	public void setRuta(RutaDTOOut ruta) {
		this.ruta = ruta;
	}
	public ParadaDTOOut getParada() {
		return parada;
	}
	public void setParada(ParadaDTOOut parada) {
		this.parada = parada;
	}
	
	
}
