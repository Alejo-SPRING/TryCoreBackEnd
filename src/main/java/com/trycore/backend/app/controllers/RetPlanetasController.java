package com.trycore.backend.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.backend.app.pojos.PlanetaAndPersonasPojo;
import com.trycore.backend.app.services.IPlanetasService;

@RestController
@RequestMapping("/planetas")
public class RetPlanetasController {

	@Autowired
	private IPlanetasService planetaService;
	private Map<String, Object> body;
	
	@GetMapping("/all")
	private ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<List<PlanetaAndPersonasPojo>>(planetaService.findAll(), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			body = new HashMap<String, Object>();
			body.put("mensaje", e.getMessage());
			body.put("mensajeEspecifico", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/contador/{planetaId}")
	private ResponseEntity<?> updateContador(@PathVariable Long planetaId) {
		try {
			return planetaService.updateContador(planetaId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			body = new HashMap<String, Object>();
			body.put("mensaje", e.getMessage());
			body.put("mensajeEspecifico", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/top3")
	private ResponseEntity<?> top3() {
		try {
			return new ResponseEntity<List<PlanetaAndPersonasPojo>>(planetaService.top3(), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			body = new HashMap<String, Object>();
			body.put("mensaje", e.getMessage());
			body.put("mensajeEspecifico", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
