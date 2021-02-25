package com.trycore.backend.app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.trycore.backend.app.pojos.PersonaPojo;

public interface IPersonasService {

	public List<PersonaPojo> findAll();

	public ResponseEntity<?> updateContador(Long idPersona);

	public List<PersonaPojo> findTop3();
	
}
