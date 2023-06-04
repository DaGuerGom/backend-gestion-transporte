package com.proyecto.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="parada")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;

	@ManyToMany
	@JoinTable(name = "ruta_parada",
    joinColumns = @JoinColumn(name = "id_parada"),
    inverseJoinColumns = @JoinColumn(name = "id_ruta"))
	@JsonIgnoreProperties("paradas")
	private List<Ruta> rutas=new ArrayList<Ruta>();	
	
	@ManyToMany
    @JoinTable(name = "usuario_parada",
    joinColumns = @JoinColumn(name = "id_parada"),
    inverseJoinColumns = @JoinColumn(name = "username"))
	@JsonIgnoreProperties("paradas")
	private List<User> usuarios=new ArrayList<User>();	
	
	public Parada(Long id, String nombre, ArrayList<Ruta> rutas,ArrayList<User> usuarios) {
		this.id = id;
		this.nombre = nombre;
		this.rutas=rutas;
		this.usuarios=usuarios;
	}

	public Parada() {
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


	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	
}
