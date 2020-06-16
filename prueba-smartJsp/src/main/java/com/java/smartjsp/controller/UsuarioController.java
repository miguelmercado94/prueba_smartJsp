package com.java.smartjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.java.smartjsp.model.DocumentoModel;
import com.java.smartjsp.model.NacionalidadModel;
import com.java.smartjsp.model.UsuarioModel;
import com.java.smartjsp.service.UsuarioService;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping()
	public ResponseEntity<List<UsuarioModel>> listarUsuariosActivos() {
		List<UsuarioModel> usuarios = usuarioService.listarTodoLosUsuariosModel();

		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuarios);
	}

	@GetMapping(value = "/{filtro}")
	public ResponseEntity<List<UsuarioModel>> listarUsuariosPorFiltro(@PathVariable("filtro") String filtro) {
		List<UsuarioModel> usuarios = usuarioService.listarUsuariosFiltradosModel(filtro);

		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuarios);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminarUsuario(@PathVariable("id") Long id) {
		UsuarioModel usuario = usuarioService.obtnerUnUsuarioModel(id);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		UsuarioModel eliminado = usuarioService.eliminarUsuarioModel(usuario);
		
		if(eliminado != null) {
			return ResponseEntity.ok(eliminado);
		}

		return ResponseEntity.badRequest().body(("No se pudo eliminar el usuario")
				);
	}

	@PutMapping
	public ResponseEntity<Object> actualizarUsuario(@RequestBody UsuarioModel usuario) {
    
		UsuarioModel usuarioEmail = usuarioService.verificarUsuarioPorEmailModel(usuario.getEmail());
		UsuarioModel usuarioIdentificador = usuarioService.verificarUsuarioPorIdentificadorModel(usuario.getIdentificacion());
		UsuarioModel usuarioTelefono = usuarioService.verificarUsuarioPorTelefonoModel(usuario.getTelefono());
		
		if(usuarioEmail!=null) {
			if(usuarioEmail.getId() != usuario.getId()) {
			return ResponseEntity.badRequest().body("Email ya se encuentra registrado");
			}
		}
		
		if(usuarioIdentificador!=null) {
			if(usuarioIdentificador.getId() != usuario.getId()) {
		    return ResponseEntity.badRequest().body("Numero de docuemnto ya se encuentra registrado");
			}
		}
		if(usuarioTelefono!=null) {
			if(usuarioTelefono.getId() != usuario.getId()) {
			return ResponseEntity.badRequest().body("Celular ya se encuuentra resgistrado");
			}
		}
		
		UsuarioModel userView = usuarioService.actualizarUsuarioModel(usuario);
		

		return ResponseEntity.ok(userView);
	}

	@PostMapping
	public ResponseEntity<Object> crearNuevoUsuario (@RequestBody UsuarioModel usuario) {

		UsuarioModel usuarioEmail = usuarioService.verificarUsuarioPorEmailModel(usuario.getEmail());
		UsuarioModel usuarioIdentificador = usuarioService.verificarUsuarioPorIdentificadorModel(usuario.getIdentificacion());
		UsuarioModel usuarioTelefono = usuarioService.verificarUsuarioPorTelefonoModel(usuario.getTelefono());
		
		if(usuarioEmail!=null) {
			if(usuarioEmail.getId() != usuario.getId()) {
			return ResponseEntity.badRequest().body("Email ya se encuentra registrado");
			}
		}
		
		if(usuarioIdentificador!=null) {
			if(usuarioIdentificador.getId() != usuario.getId()) {
		    return ResponseEntity.badRequest().body("Numero de docuemnto ya se encuentra registrado");
			}
		}
		if(usuarioTelefono!=null) {
			if(usuarioTelefono.getId() != usuario.getId()) {
			return ResponseEntity.badRequest().body("Celular ya se encuuentra resgistrado");
			}
		}
		
		UsuarioModel userView = usuarioService.crearNuevoUsuarioModel(usuario);
		

		return ResponseEntity.ok(userView);
		
	}

}
