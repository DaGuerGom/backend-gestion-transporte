package com.proyecto.dto;

import java.util.List;

public class UserDTOIn {
	private String username;
	private String password;
	private String email;
	private String tipo;
	private char admitido;
	private List<Long> rutas;
	private List<Long> paradas;
	
	public UserDTOIn(String username, String password, String email,String tipo,char admitido,List<Long> rutas,List<Long> paradas) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.tipo=tipo;
		this.admitido=admitido;
		this.rutas=rutas;
		this.paradas=paradas;
	}
	public UserDTOIn() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public List<Long> getParadas() {
		return paradas;
	}
	public void setParadas(List<Long> paradas) {
		this.paradas = paradas;
	}
	public char getAdmitido() {
		return admitido;
	}
	public void setAdmitido(char admitido) {
		this.admitido = admitido;
	}
	
}
