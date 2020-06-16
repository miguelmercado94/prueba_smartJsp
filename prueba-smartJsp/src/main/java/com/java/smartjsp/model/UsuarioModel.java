package com.java.smartjsp.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.java.smartjsp.entity.Usuario;


public class UsuarioModel {

    private Long id;	
	
    @NotEmpty(message="El nombre no puede estar vacio")
	private String nombre;
    
    @NotEmpty(message="El apellido no puede estar vacio")
	private String apellido;
	
    @Email(message = "formato de email incorrecto")
	private String email;
	
	private String observaciones;
	
	private Date createAt;
	
	private String estado;
	
	@Positive(message = "formato incorrecto")
	private Long telefono;
	
	@Positive(message = "formato de cedula incorrecto")
	private Long identificacion;

	@Valid
	@NotNull(message = "Seleccionar una nacionalidad")
	private NacionalidadModel nacionalidad;
	
	@Valid
	@NotNull(message = "Seleccionar un tipo de docuemnto")
	private DocumentoModel documento;

	public UsuarioModel() {
	}

	public UsuarioModel(Long id, String nombre, String apellido, String email, String observaciones,
			Date createAt, String estado, Long telefono, NacionalidadModel nacionalidad, DocumentoModel documento, Long identificacion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.observaciones = observaciones;
		this.createAt = createAt;
		this.estado = estado;
		this.telefono = telefono;
		this.nacionalidad = nacionalidad;
		this.documento = documento;
		this.identificacion=identificacion;
	}

	public UsuarioModel(Usuario usuario){
		
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
		this.observaciones = usuario.getObservaciones();
		this.createAt = usuario.getCreateAt();
		this.estado = usuario.getEstado();
		this.telefono = usuario.getTelefono();
		this.nacionalidad = new NacionalidadModel(usuario.getNacionalidad());
		this.documento = new DocumentoModel(usuario.getTpDocumento());
		this.identificacion = usuario.getIdentificador();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public NacionalidadModel getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(NacionalidadModel nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public DocumentoModel getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoModel documento) {
		this.documento = documento;
	}
	
	
	
}
