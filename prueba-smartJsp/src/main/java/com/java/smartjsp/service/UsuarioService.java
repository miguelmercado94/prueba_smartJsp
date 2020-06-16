package com.java.smartjsp.service;

import java.util.List;

import com.java.smartjsp.model.UsuarioModel;

public interface UsuarioService {

	
    public List<UsuarioModel> listarTodoLosUsuariosModel();
	
	public List<UsuarioModel> listarUsuariosFiltradosModel(String filtro);
	
	public UsuarioModel crearNuevoUsuarioModel(UsuarioModel usario);
	
	public UsuarioModel obtnerUnUsuarioModel(Long id);
	
	public UsuarioModel actualizarUsuarioModel(UsuarioModel usuario);
	
	public UsuarioModel eliminarUsuarioModel(UsuarioModel usuario);
	
	public UsuarioModel verificarUsuarioPorIdentificadorModel(Long identificador);
	
	public UsuarioModel verificarUsuarioPorEmailModel(String email);
	
	public UsuarioModel verificarUsuarioPorTelefonoModel(Long telefono);
	
}
