package com.proyecto.dto;

public class UsuarioRutaAutobusDTOOut {
	private Long id;
	private UserDTOOut usuario;
	private RutaDTOOut ruta;
	private AutobusDTOOut autobus;
	public UsuarioRutaAutobusDTOOut(Long id, UserDTOOut usuario, RutaDTOOut ruta, AutobusDTOOut autobus) {
		this.id = id;
		this.usuario = usuario;
		this.ruta = ruta;
		this.autobus = autobus;
	}
	public UsuarioRutaAutobusDTOOut() {
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
	public AutobusDTOOut getAutobus() {
		return autobus;
	}
	public void setAutobus(AutobusDTOOut autobus) {
		this.autobus = autobus;
	}
	
	
}
