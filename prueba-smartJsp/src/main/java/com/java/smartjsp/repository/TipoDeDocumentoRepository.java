package com.java.smartjsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.smartjsp.entity.TipoDeDocumento;

@Repository
public interface TipoDeDocumentoRepository extends JpaRepository<TipoDeDocumento ,Long>{

	public TipoDeDocumento findByNombre(String nombre);
	
}
