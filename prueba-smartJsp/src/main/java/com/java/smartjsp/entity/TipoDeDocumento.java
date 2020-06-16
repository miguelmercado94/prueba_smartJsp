package com.java.smartjsp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_tipos_documentos")
public class TipoDeDocumento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String nombre;
	@Column(unique=true)
	private String abreviacion;	
	
	@OneToMany(mappedBy="tpDocumento")
	private List<Usuario> usuarios; 
	
	public TipoDeDocumento() {
		this.usuarios = new ArrayList<>();
	}

	public TipoDeDocumento(Long id, String nombre, String abreviacion) {
		this.id = id;
		this.nombre = nombre;
		this.abreviacion = abreviacion;
		this.usuarios = new ArrayList<>();
	}
	public TipoDeDocumento( String nombre, String abreviacion) {
		this.nombre = nombre;
		this.abreviacion = abreviacion;
		this.usuarios = new ArrayList<>();
		this.id = null;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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



	public String getAbreviacion() {
		return abreviacion;
	}



	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}
	
	
	
}
