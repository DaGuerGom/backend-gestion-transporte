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
@Table(name="autobus")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Autobus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="capacidad")
	private int capacidad;
	
	@ManyToMany
    @JoinTable(name = "ruta_autobus",
            joinColumns = @JoinColumn(name = "id_autobus"),
            inverseJoinColumns = @JoinColumn(name = "id_ruta"))
    @JsonIgnoreProperties("autobuses")
    private List<Ruta> rutas = new ArrayList<>();
	
	public Autobus(Long id, String nombre, int capacidad,ArrayList<Ruta> rutas) {
		this.id = id;
		this.nombre=nombre;
		this.capacidad = capacidad;
		this.rutas=rutas;
	}

	public Autobus() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
