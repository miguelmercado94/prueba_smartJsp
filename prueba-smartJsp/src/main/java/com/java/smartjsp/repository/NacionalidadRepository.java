package com.java.smartjsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.smartjsp.entity.Nacionalidad;
@Repository
public interface NacionalidadRepository extends JpaRepository<Nacionalidad,Long>{

	public Nacionalidad findByNombre(String nombre);
}
