package com.proyecto.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="admitido")
	private char admitido;

	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "usuario_ruta",
	        joinColumns = @JoinColumn(name = "username"),
	        inverseJoinColumns = @JoinColumn(name = "id_ruta"))
	@JsonIgnoreProperties("usuarios")
	private List<Ruta> rutas = new ArrayList<>();

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
    @JoinTable(name = "usuario_parada",
               joinColumns = @JoinColumn(name = "username"),
               inverseJoinColumns = @JoinColumn(name = "id_parada"))
	@JsonIgnoreProperties("usuarios")
    private List<Parada> paradas;
	
	public User(String username, String password, String email, String tipo, char admitido,ArrayList<Ruta> rutas, ArrayList<Parada> paradas) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.tipo = tipo;
		this.admitido = admitido;
		this.rutas=rutas;
		this.paradas=paradas;
	}

	public User() {
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

	public char getAdmitido() {
		return admitido;
	}

	public void setAdmitido(char admitido) {
		this.admitido = admitido;
	}

	
	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public List<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}
	
	
}
