package com.java.smartjsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.smartjsp.entity.Nacionalidad;
import com.java.smartjsp.entity.TipoDeDocumento;
import com.java.smartjsp.entity.Usuario;
import com.java.smartjsp.model.UsuarioModel;
import com.java.smartjsp.repository.NacionalidadRepository;
import com.java.smartjsp.repository.TipoDeDocumentoRepository;
import com.java.smartjsp.repository.UsuarioRepository;

@Service
public class UsuarioServiceImple implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	NacionalidadRepository nacionalidadRepository;

	@Autowired
	TipoDeDocumentoRepository tipoDeDocumentoRepository;

	
	// -----------------por model--------------

	@Override
	public List<UsuarioModel> listarTodoLosUsuariosModel() {
		List<UsuarioModel> usuarioModel = convertidorLista(usuarioRepository.encontrarUsuariosNoEliminados());
		return usuarioModel;
	}

	@Override
	public List<UsuarioModel> listarUsuariosFiltradosModel(String filtro) {
		List<UsuarioModel> usuarioModel = convertidorLista(usuarioRepository.encontrarUsuariosFiltrados(filtro));
		return usuarioModel;
	}

	@Override
	public UsuarioModel crearNuevoUsuarioModel(UsuarioModel usuario) {
		
		Nacionalidad nacionalidadBD = nacionalidadRepository.findByNombre(usuario.getNacionalidad().getNombre());
		if(nacionalidadBD == null) {
			 nacionalidadBD = nacionalidadRepository.save(new Nacionalidad(usuario.getNacionalidad().getNombre()));
		}
 
		TipoDeDocumento tipoDeDocumento = tipoDeDocumentoRepository.findByNombre(usuario.getDocumento().getNombre());
		
		if(tipoDeDocumento == null) {
		tipoDeDocumento = tipoDeDocumentoRepository.save(new TipoDeDocumento(
				usuario.getDocumento().getNombre(),
				usuario.getDocumento().getAbreviacion()
				));
		}
		
		Usuario usuarioBD = new Usuario();
		usuarioBD.setNombre(usuario.getNombre());
		usuarioBD.setApellido(usuario.getApellido());
		usuarioBD.setObservaciones(usuario.getObservaciones());
		usuarioBD.setIdentificador(usuario.getIdentificacion());
		usuarioBD.setTelefono(usuario.getTelefono());
		usuarioBD.setEmail(usuario.getEmail());
		usuarioBD.setTpDocumento(tipoDeDocumento);
		usuarioBD.setNacionalidad(nacionalidadBD);
		usuarioBD.setEstado("CREADO");

		usuarioBD = usuarioRepository.save(usuarioBD);

		UsuarioModel usuarioModel = new UsuarioModel(usuarioBD);

		return usuarioModel;
	}

	@Override
	public UsuarioModel actualizarUsuarioModel(UsuarioModel usuario) {
		
		Nacionalidad nacionalidadBD = nacionalidadRepository.findByNombre(usuario.getNacionalidad().getNombre());
		if(nacionalidadBD == null) {
			 nacionalidadBD = nacionalidadRepository.save(new Nacionalidad(usuario.getNacionalidad().getNombre()));
		}

		TipoDeDocumento tipoDeDocumento = tipoDeDocumentoRepository.findByNombre(usuario.getDocumento().getNombre());
		
		if(tipoDeDocumento == null) {
		tipoDeDocumento = tipoDeDocumentoRepository.save(new TipoDeDocumento(
				usuario.getDocumento().getNombre(),
				usuario.getDocumento().getAbreviacion()
				));
		}

		Usuario usuarioBD = usuarioRepository.findById(usuario.getId()).orElse(null);
		if(usuarioBD == null) {
			return null;
		}
		usuarioBD.setNombre(usuario.getNombre());
		usuarioBD.setApellido(usuario.getApellido());
		usuarioBD.setObservaciones(usuario.getObservaciones());
		usuarioBD.setIdentificador(usuario.getIdentificacion());
		usuarioBD.setTelefono(usuario.getTelefono());
		usuarioBD.setTpDocumento(tipoDeDocumento);
		usuarioBD.setNacionalidad(nacionalidadBD);
		
		usuarioBD = usuarioRepository.save(usuarioBD);
		
		if(usuarioBD != null) {
			
			return new UsuarioModel(usuarioBD);
		}else {
			
			return null;
		}
	}

	@Override
	public UsuarioModel eliminarUsuarioModel(UsuarioModel usuario) {

		Usuario usuarioBD = usuarioRepository.findById(usuario.getId()).orElse(null);
		
		if(usuarioBD == null) {return null;}

		usuarioBD.setEstado("ELIMINADO");
		
		usuarioBD = usuarioRepository.save(usuarioBD);
		if(usuarioBD.getEstado().equals("ELIMINADO")) return new UsuarioModel(usuarioBD);
		
		return null;
	}

	@Override
	public UsuarioModel obtnerUnUsuarioModel(Long id) {
		Usuario usuarioBD = usuarioRepository.findById(id).orElse(null);
		if(usuarioBD == null) {return null;}
		return new UsuarioModel(usuarioBD);
	}

	@Override
	public UsuarioModel verificarUsuarioPorIdentificadorModel(Long identificador) {
		Usuario usuarioBD = usuarioRepository.findUsuarioByIdentificador(identificador);
		if(usuarioBD != null ) return new UsuarioModel(usuarioBD);
		return null;
	}

	@Override
	public UsuarioModel verificarUsuarioPorEmailModel(String email) {
		Usuario usuarioBD = usuarioRepository.findUsuarioByEmail(email);
		if(usuarioBD != null ) return new UsuarioModel(usuarioBD);
		return null;
	}

	@Override
	public UsuarioModel verificarUsuarioPorTelefonoModel(Long telefono) {
		Usuario usuarioBD = usuarioRepository.findUsuarioByTelefono(telefono);
		if(usuarioBD != null ) return new UsuarioModel(usuarioBD);
		return null;
	}

	private List<UsuarioModel> convertidorLista(List<Usuario> usuarios) {
		List<UsuarioModel> usuarioModel = new ArrayList<>();
		if (!usuarios.isEmpty()) {
			for (Usuario usuarioAux : usuarios) {
				usuarioModel.add(new UsuarioModel(usuarioAux));
			}

		}

		return usuarioModel;
	}

}
