package com.java.smartjsp.service;

import java.util.List;

import com.java.smartjsp.model.DocumentoModel;

public interface TipoDeDocumentoService {

	public List<DocumentoModel> listarTodosLosTiposDeDocumentos();
	
	public DocumentoModel obtenerUnTipoDeDocumento(Long id);
}
