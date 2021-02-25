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
import com.trycore.backend.app.model.entitys.Persona;
import com.trycore.backend.app.model.entitys.PersonaHasPlaneta;
import com.trycore.backend.app.model.entitys.Planeta;
import com.trycore.backend.app.model.services.IPersonaHasPlanetaServiceDao;
import com.trycore.backend.app.model.services.IPersonaServiceDao;
import com.trycore.backend.app.model.services.IPlanetaServiceDao;
import com.trycore.backend.app.pojos.PersonaPojo;

@Service
public class PersonasServiceImpl implements IPersonasService{

	@Autowired
	private IPersonaServiceDao personaServiceDao;
	@Autowired
	private IPersonaHasPlanetaServiceDao personaHasPlanetaServiceDao;
	@Autowired
	private IPlanetaServiceDao planetaServiceDao;
	private Map<String, Object> body;
	
	@Transactional(readOnly = true)
	@Override
	public List<PersonaPojo> findAll() {
		List<PersonaPojo> personas = new ArrayList<PersonaPojo>();
		for(Persona persona : personaServiceDao.findAll()) {
			PersonaHasPlaneta personaHasPlaneta = personaHasPlanetaServiceDao.findForPersona(persona);
			if(personaHasPlaneta != null) {
				personas.add(new PersonaPojo(persona, personaHasPlaneta.getPlaneta()));
			} else {
				personas.add(new PersonaPojo(persona, null));
			}
		}
		return personas;
	}

	@Transactional
	@Override
	public ResponseEntity<?> updateContador(Long idPersona) {
		Persona persona = personaServiceDao.findById(idPersona).orElse(null);
		body = new HashMap<String, Object>();
		if(persona != null) {
			persona.setContador(persona.getContador() + 1);
			personaServiceDao.save(persona);
			Planeta planeta = personaHasPlanetaServiceDao.findForPersona(persona).getPlaneta();
			if(planeta != null) {
				planeta.setContador(planeta.getContador() + 1);
				planetaServiceDao.save(planeta);
			}
			body.put("mensaje", Mensajes.PERSONA_ACTUALIZADA.getMensaje());
			body.put("persona", new PersonaPojo(persona, planeta));
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.CREATED);
		} else {
			body.put("mensaje", Mensajes.PERSONA_NO_ENCONTRADA.getMensaje());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<PersonaPojo> findTop3() {
		List<PersonaPojo> personas = new ArrayList<PersonaPojo>();
		for(Persona persona : personaServiceDao.findTop3()) {
			PersonaHasPlaneta personaHasPlaneta = personaHasPlanetaServiceDao.findForPersona(persona);
			if(personaHasPlaneta != null) {
				personas.add(new PersonaPojo(persona, personaHasPlaneta.getPlaneta()));
			} else {
				personas.add(new PersonaPojo(persona, null));
			}
		}
		return personas;
	}
}
