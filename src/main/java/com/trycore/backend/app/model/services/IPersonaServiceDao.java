package com.trycore.backend.app.model.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trycore.backend.app.model.entitys.Persona;

public interface IPersonaServiceDao extends CrudRepository<Persona, Long>{

	@Query(value = "SELECT * FROM Persona p ORDER BY p.contador DESC LIMIT 3", nativeQuery = true)
	public List<Persona> findTop3();
	
}
