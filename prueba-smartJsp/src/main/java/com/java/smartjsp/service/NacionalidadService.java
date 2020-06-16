package com.java.smartjsp.service;

import java.util.List;

import com.java.smartjsp.model.NacionalidadModel;

public interface NacionalidadService {

	public List<NacionalidadModel> listarTodasLasNacionalidad();
	
	public NacionalidadModel obtenerNacionalidad(Long id);
	
}
