package com.java.smartjsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.smartjsp.entity.Nacionalidad;
import com.java.smartjsp.model.NacionalidadModel;
import com.java.smartjsp.repository.NacionalidadRepository;

@Service
public class NacionalidadServiceImple implements NacionalidadService{

	@Autowired
	NacionalidadRepository nacionalidadRepository;
	
	
	@Override
	public List<NacionalidadModel> listarTodasLasNacionalidad() {
		
		List<NacionalidadModel> nacionalidadesModel = new ArrayList<>();
		
		List<Nacionalidad> nacionalidades = nacionalidadRepository.findAll();
	
		if(!nacionalidades.isEmpty()) {
		for(Nacionalidad nacionalidadAux: nacionalidades ) {
			
			nacionalidadesModel.add(new NacionalidadModel(nacionalidadAux));
		}
		}
		
		return nacionalidadesModel;
	}


	@Override
	public NacionalidadModel obtenerNacionalidad(Long id) {
		
		Nacionalidad nacionalidadDB = nacionalidadRepository.findById(id).orElse(null);
		
		if(nacionalidadDB == null) return null;
		
		return new NacionalidadModel(nacionalidadDB);
	}

}
