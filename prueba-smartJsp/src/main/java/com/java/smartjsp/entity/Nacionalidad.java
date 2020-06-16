package com.java.smartjsp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_nacionalidades")
public class Nacionalidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre_pais", unique=true)	
	private String nombre;
	
	@OneToMany(mappedBy="nacionalidad")
	private List<Usuario> usuarios; 
	
	public Nacionalidad() {
		this.usuarios = new ArrayList<>();
	}
	public Nacionalidad(String nombre) {
		this.nombre = nombre;
		this.usuarios = new ArrayList<>();
		this.id=null;
	}
   

	public Nacionalidad(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.usuarios = new ArrayList<>();
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
	
	
	
}
