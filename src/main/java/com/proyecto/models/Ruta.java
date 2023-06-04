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
@Table(name="ruta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="hora_salida")
	private String horaSalida;
	
	@Column(name="hora_llegada")
	private String horaLlegada;

	@ManyToMany
	@JoinTable(name = "usuario_ruta",
    joinColumns = @JoinColumn(name = "id_ruta"),
    inverseJoinColumns = @JoinColumn(name = "username"))
    private List<User> usuarios = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "ruta_parada",
	           joinColumns = @JoinColumn(name = "id_ruta"),
	           inverseJoinColumns = @JoinColumn(name = "id_parada"))
	@JsonIgnoreProperties("rutas")
	private List<Parada> paradas = new ArrayList<>();


	@ManyToMany
	@JoinTable(name = "ruta_autobus",
    joinColumns = @JoinColumn(name = "id_ruta"),
    inverseJoinColumns = @JoinColumn(name = "id_autobus"))
    @JsonIgnoreProperties("rutas")
    private List<Autobus> autobuses = new ArrayList<>();
		
	public Ruta(Long id, String nombre, String horaSalida, String horaLlegada, ArrayList<User>usuarios,ArrayList<Autobus> autobuses) {
		this.id = id;
		this.nombre = nombre;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.usuarios=usuarios;
		this.autobuses=autobuses;
	}

	public Ruta() {
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

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}

	public List<Autobus> getAutobuses() {
		return autobuses;
	}

	public void setAutobuses(List<Autobus> autobuses) {
		this.autobuses = autobuses;
	}
	
}
