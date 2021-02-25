package com.trycore.backend.app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.trycore.backend.app.pojos.PlanetaAndPersonasPojo;

public interface IPlanetasService {

	public List<PlanetaAndPersonasPojo> findAll();
	
	public ResponseEntity<?> updateContador(Long planetaId);
	
	public List<PlanetaAndPersonasPojo> top3();
	
}
