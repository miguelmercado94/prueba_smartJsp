package com.java.smartjsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.smartjsp.model.NacionalidadModel;
import com.java.smartjsp.service.NacionalidadService;

@RestController
@RequestMapping("/nacionalidades")
public class NacionalidadController {

	@Autowired
	NacionalidadService nacionalidadService;
	
	@GetMapping 
    public ResponseEntity<List<NacionalidadModel>> listarTodos(){
		
		List<NacionalidadModel> nacionalidadModel = nacionalidadService.listarTodasLasNacionalidad();
		
		if(nacionalidadModel.isEmpty()) {
		return ResponseEntity.noContent().build();	
		}
		return ResponseEntity.ok(nacionalidadModel) ;
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<NacionalidadModel> obtnerUnaNacionalidad(@PathVariable("id") Long id){
		
		NacionalidadModel nacionalidadModel = nacionalidadService.obtenerNacionalidad(id);
		
		if(nacionalidadModel == null) {
		return ResponseEntity.noContent().build();	
		}
		return ResponseEntity.ok(nacionalidadModel) ;
	}
	
}
