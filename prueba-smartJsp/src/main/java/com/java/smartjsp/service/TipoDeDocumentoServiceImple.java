package com.java.smartjsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.smartjsp.entity.TipoDeDocumento;
import com.java.smartjsp.model.DocumentoModel;
import com.java.smartjsp.repository.TipoDeDocumentoRepository;

@Service
public class TipoDeDocumentoServiceImple implements TipoDeDocumentoService{

	@Autowired
	TipoDeDocumentoRepository tipoDeDocumentoRepository;
	
	
	
	
	@Override
	public List<DocumentoModel> listarTodosLosTiposDeDocumentos() {

		List<DocumentoModel> documentoModel = new ArrayList<>();
		
		List<TipoDeDocumento> tipoDeDocumentoDB = tipoDeDocumentoRepository.findAll();
		
		if(!tipoDeDocumentoDB.isEmpty()) {
		for(TipoDeDocumento tipoDeDocumentoAux: tipoDeDocumentoDB ) {
			
			documentoModel.add(new DocumentoModel(tipoDeDocumentoAux));
		}
		}		
		
		return documentoModel;
	}

	@Override
	public DocumentoModel obtenerUnTipoDeDocumento(Long id) {
		
		TipoDeDocumento tpDocumentoDB = tipoDeDocumentoRepository.findById(id).orElse(null);
		
		if(tpDocumentoDB == null) return null;
		
		return new DocumentoModel(tpDocumentoDB);
	}
	
	

}
