package smartJsp.bean.web.model;

public class Documento {

	private Long id;
	
	private String nombre;
	
	private String abreviacion;

	public Documento() {}
	
	public Documento(Long id, String nombre, String abreviacion) {
		this.id = id;
		this.nombre = nombre;
		this.abreviacion = abreviacion;
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
