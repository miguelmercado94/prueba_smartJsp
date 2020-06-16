package smartJsp.bean.web.model;

import java.util.Date;

import javax.validation.constraints.*;
import javax.validation.Valid;


public class Usuario {
	
	Long id;
	
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
	private Nacionalidad nacionalidad;

	@Valid
	@NotNull(message = "Seleccionar un documento")
	private Documento documento;

	public Usuario() {
		
		documento = new Documento();
		nacionalidad = new Nacionalidad();
		
	}

	public Usuario(Long id, String nombre, String apellido, String email, String observaciones, Date createAt,
			String estado, Long telefono, Long identificacion, Nacionalidad nacionalidad, Documento documento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.observaciones = observaciones;
		this.createAt = createAt;
		this.estado = estado;
		this.telefono = telefono;
		this.identificacion = identificacion;
		this.nacionalidad = nacionalidad;
		this.documento = documento;
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

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}
