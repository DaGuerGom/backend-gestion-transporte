package com.proyecto.dto;

import java.util.ArrayList;
import java.util.List;

//Datos que se mostraran haciendo peticion si no se es admin
public class UserDTOOut {
	private String username;
	private String email;
	private String tipo;
	private char admitido;
	private List<Long> rutas;
	
	public UserDTOOut(String username, String email, String tipo,char admitido, List<Long> rutas) {
		this.username = username;
		this.email = email;
		this.tipo = tipo;
		this.admitido=admitido;
		this.rutas=rutas;
	}

	public UserDTOOut() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Long> getRutas() {
		return rutas;
	}

	public void setRutas(List<Long> rutas) {
		this.rutas = rutas;
	}

	public char getAdmitido() {
		return admitido;
	}

	public void setAdmitido(char admitido) {
		this.admitido = admitido;
	}
	
}


