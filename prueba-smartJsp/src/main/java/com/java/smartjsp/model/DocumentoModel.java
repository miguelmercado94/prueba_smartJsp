package com.java.smartjsp.model;

import com.java.smartjsp.entity.TipoDeDocumento;

public class DocumentoModel {

	private String abreviacion;
	
	private String nombre;
	
	private Long id;

	public DocumentoModel() {
		
	}
	
	public DocumentoModel(Long id, String abreviacion, String nombre) {
		this.abreviacion = abreviacion;
		this.nombre = nombre;
	}
	
	public DocumentoModel(TipoDeDocumento tpDocumento) {
		
		this.abreviacion = tpDocumento.getAbreviacion();
		this.nombre = tpDocumento.getNombre();
		this.id = tpDocumento.getId();
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
