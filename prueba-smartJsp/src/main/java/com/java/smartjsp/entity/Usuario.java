package com.java.smartjsp.entity;

import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="tbl_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	private String nombre;
	
	private String apellido;
	
	@Column(unique=true)
	private Long identificador;
	
	@Column(unique=true)
	private String email;
	
	private String observaciones;
	
	@Column(name="creat_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	private String estado;
	
	@Column(unique=true)
	private Long telefono;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="nacionalidad_id")
	private Nacionalidad nacionalidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_documento_id")
	private TipoDeDocumento tpDocumento;
	
	public Usuario() {}

	public Usuario(Long id, String nombre, String apellido, Long identificador, String email, String observaciones,
			Date createAt, String estado, Nacionalidad nacionalidad, TipoDeDocumento tpDocumento, Long telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificador = identificador;
		this.email = email;
		this.observaciones = observaciones;
		this.createAt = createAt;
		this.estado = estado;
		this.nacionalidad = nacionalidad;
		this.tpDocumento = tpDocumento;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
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

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
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

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public TipoDeDocumento getTpDocumento() {
		return tpDocumento;
	}

	public void setTpDocumento(TipoDeDocumento tpDocumento) {
		this.tpDocumento = tpDocumento;
	}
	
	@PrePersist
	public void prePersist() {
		
		this.createAt = new Date() ;
	}
	
	
}
