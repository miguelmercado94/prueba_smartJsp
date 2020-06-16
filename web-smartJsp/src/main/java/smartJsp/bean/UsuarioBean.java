package smartJsp.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericType;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import smartJsp.bean.web.model.Documento;
import smartJsp.bean.web.model.Nacionalidad;
import smartJsp.bean.web.model.Usuario;
import smartJsp.bean.web.rest.*;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String REST_URI = "http://localhost:8082/";

	private List<Usuario> listUsuarios = new ArrayList<>();

	private List<Documento> documentos = new ArrayList<>();
	
	private List<Nacionalidad> nacionalidades = new ArrayList<>();
	
	@Valid
	private Usuario usarioBD;

	private UsuarioEndpoint usuarioEndpoint;

	private TpDocumentoEndPoint tpDocumentoEndPoint;

	private NacionalidadEndPoint nacionalidadEndPoint;


	public UsuarioBean() {
		usuarioEndpoint = JAXRSClientFactory.create(REST_URI, UsuarioEndpoint.class,
				Arrays.asList(new JacksonJaxbJsonProvider()));
		nacionalidadEndPoint = JAXRSClientFactory.create(REST_URI, NacionalidadEndPoint.class,
				Arrays.asList(new JacksonJaxbJsonProvider()));
		tpDocumentoEndPoint = JAXRSClientFactory.create(REST_URI, TpDocumentoEndPoint.class,
				Arrays.asList(new JacksonJaxbJsonProvider()));

		listUsuarios = this.cargarlista();
		documentos = this.cargarListaDocumentos();
		nacionalidades = this.cargarListaNacionalidades();
		usarioBD = new Usuario();
	}

	
	
	public Usuario getUsarioBD() {
		return usarioBD;
	}



	public void setUsarioBD(Usuario usarioBD) {
		this.usarioBD = usarioBD;
	}


	public List<Documento> getDocumentos() {

		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public List<Nacionalidad> getNacionalidades() {
	return nacionalidades;
	}

	public void setNacionalidades(List<Nacionalidad> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}



	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public String eliminarUsuario(Long id) {
		Response resp = usuarioEndpoint.delete(id);

		if (resp.getStatus() == Response.Status.OK.getStatusCode()) {

			listUsuarios = this.cargarlista();

		}

		return "index.xhtml?faces-redirect=true";
	}
	
	public String guardarUsuario() {
		Response resp;
		if(usarioBD.getId()!= null ) {
			
			 resp = usuarioEndpoint.update(usarioBD);
		}else {
			 resp = usuarioEndpoint.create(usarioBD);
		}
		
		if(resp.getStatus() == Response.Status.OK.getStatusCode()) {
			usarioBD = new Usuario();
			listUsuarios = this.cargarlista();
			return "index.xhtml?faces-redirect=true";
		}
		
		
		return "Nuevo.xhtml?faces-redirect=true";
	}
	
    public String irActualizar(Usuario u) {
    	usarioBD = u;
    	
    	return "Nuevo.xhtml?faces-redirect=true";
    }
	
    public String irNuevoUsuario() {
    	
    	usarioBD = new Usuario();
    	return "Nuevo.xhtml?faces-redirect=true";
    }
    
	private List<Usuario> cargarlista() {
		Response resp = usuarioEndpoint.list();
		List<Usuario> usuarios = new ArrayList<>();

		if (resp.getStatus() == Response.Status.OK.getStatusCode()) {

			usuarios = (List<Usuario>) resp.readEntity(new GenericType<List<Usuario>>() {
			});

		}

		return usuarios;
	}
	private List<Documento> cargarListaDocumentos(){
		Response resp = tpDocumentoEndPoint.list();

		if (resp.getStatus() == Response.Status.OK.getStatusCode()) {

			documentos = (List<Documento>) resp.readEntity(new GenericType<List<Documento>>() {
			});
		}
		
		return documentos;
	}
	
	private List<Nacionalidad> cargarListaNacionalidades(){
		
		Response resp = nacionalidadEndPoint.list();

		if (resp.getStatus() == Response.Status.OK.getStatusCode()) {

			nacionalidades = (List<Nacionalidad>) resp.readEntity(new GenericType<List<Nacionalidad>>() {
			});
		}
		
		return nacionalidades;
		
	}

}
