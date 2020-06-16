package com.java.smartjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.smartjsp.model.DocumentoModel;
import com.java.smartjsp.service.TipoDeDocumentoService;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {
	
	@Autowired
	TipoDeDocumentoService tipoDeDocumentoService;

	@GetMapping
	public ResponseEntity<List<DocumentoModel>> listarTodos(){
		
		List<DocumentoModel> tpDocumentos = tipoDeDocumentoService.listarTodosLosTiposDeDocumentos();
		
		if(tpDocumentos.isEmpty()) {
		return ResponseEntity.noContent().build();	
		}
		return ResponseEntity.ok(tpDocumentos) ;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentoModel> obtnerUnTipoDeDocumento(@PathVariable("id") Long id){
		
		DocumentoModel tpDocumento = tipoDeDocumentoService.obtenerUnTipoDeDocumento(id);
		
		if(tpDocumento == null) {
		return ResponseEntity.noContent().build();	
		}
		return ResponseEntity.ok(tpDocumento) ;
	}
}
