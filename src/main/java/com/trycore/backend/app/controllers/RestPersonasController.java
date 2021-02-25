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

import com.trycore.backend.app.pojos.PersonaPojo;
import com.trycore.backend.app.services.IPersonasService;

@RestController
@RequestMapping("/personas")
public class RestPersonasController {

	@Autowired
	private IPersonasService personasService;
	private Map<String, Object> body;
	
	@GetMapping("/all")
	private ResponseEntity<?> findAll(){
		try {
			return new ResponseEntity<List<PersonaPojo>>(personasService.findAll(), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			body = new HashMap<>();
			body.put("mensaje", e.getMessage());
			body.put("mensajeEspecific", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/contador/{idPersona}")
	private ResponseEntity<?> findAll(@PathVariable(required = true) Long idPersona){
		try {
			return personasService.updateContador(idPersona);
		} catch (DataAccessException e) {
			e.printStackTrace();
			body = new HashMap<>();
			body.put("mensaje", e.getMessage());
			body.put("mensajeEspecific", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/top3")
	private ResponseEntity<?> top3(){
		try {
			return new ResponseEntity<List<PersonaPojo>>(personasService.findTop3(), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			body = new HashMap<>();
			body.put("mensaje", e.getMessage());
			body.put("mensajeEspecific", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
