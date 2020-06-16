package com.java.smartjsp.model;

import com.java.smartjsp.entity.Nacionalidad;

public class NacionalidadModel {

	private Long id;
	
	private String nombre;

	public NacionalidadModel() {
	}

	public NacionalidadModel(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public NacionalidadModel(Nacionalidad nacionalidad) {
		this.id = nacionalidad.getId();
		this.nombre = nacionalidad.getNombre(); 
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
	
	
	
}
