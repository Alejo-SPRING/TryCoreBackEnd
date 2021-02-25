package com.trycore.backend.app.model.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.trycore.backend.app.model.entitys.Persona;
import com.trycore.backend.app.model.entitys.PersonaHasPlaneta;

public interface IPersonaHasPlanetaServiceDao extends CrudRepository<PersonaHasPlaneta, Long>{

	@Query("SELECT p FROM PersonaHasPlaneta p WHERE p.persona = :persona")
	public PersonaHasPlaneta findForPersona(@Param("persona") Persona persona);
	
}
