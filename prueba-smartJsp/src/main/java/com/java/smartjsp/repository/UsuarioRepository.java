package com.java.smartjsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.smartjsp.entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	@Query(value="SELECT u FROM Usuario u WHERE u.nombre like %:filtro% OR u.apellido like %:filtro% OR u.identificador like %:filtro%" )
	public List<Usuario> encontrarUsuariosFiltrados(String filtro);
	
	public Usuario findUsuarioByIdentificador (Long identificador);
	
	public Usuario findUsuarioByEmail (String email);
	
	public Usuario findUsuarioByTelefono (Long telefono);
	
	@Query(value="SELECT u FROM Usuario u WHERE NOT u.estado = 'ELIMINADO'")
	public List<Usuario> encontrarUsuariosNoEliminados();
	
}
