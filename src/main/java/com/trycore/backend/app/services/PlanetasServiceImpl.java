package com.trycore.backend.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trycore.backend.app.enums.Mensajes;
import com.trycore.backend.app.model.entitys.Planeta;
import com.trycore.backend.app.model.services.IPlanetaServiceDao;
import com.trycore.backend.app.pojos.PlanetaAndPersonasPojo;
import com.trycore.backend.app.pojos.PlanetaPojo;

@Service
public class PlanetasServiceImpl implements IPlanetasService{

	@Autowired
	private IPlanetaServiceDao planetaServiceDao;
	private Map<String, Object> body;
	
	@Transactional(readOnly = true)
	@Override
	public List<PlanetaAndPersonasPojo> findAll() {
		List<PlanetaAndPersonasPojo> planetas = new ArrayList<>();
		for(Planeta planeta : planetaServiceDao.findAll()) {
			planetas.add(new PlanetaAndPersonasPojo(planeta));
		}
		return planetas;
	}

	@Transactional
	@Override
	public ResponseEntity<?> updateContador(Long planetaId) {
		Planeta planeta = planetaServiceDao.findById(planetaId).orElse(null);
		body = new HashMap<>();
		if(planeta != null) {
			planeta.setContador(planeta.getContador() + 1);
			planetaServiceDao.save(planeta);
			body.put("mensaje", Mensajes.PLANETA_ACTUALIZADO.getMensaje());
			body.put("planeta", new PlanetaPojo(planeta));
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.CREATED);
		} else {
			body.put("mensaje", Mensajes.PLANETA_NO_ENCONTRADO.getMensaje());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<PlanetaAndPersonasPojo> top3() {
		List<PlanetaAndPersonasPojo> planetas = new ArrayList<>();
		for(Planeta planeta : planetaServiceDao.findTop3()) {
			planetas.add(new PlanetaAndPersonasPojo(planeta));
		}
		return planetas;
	}

}
