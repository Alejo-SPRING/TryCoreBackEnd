package com.trycore.backend.app.model.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trycore.backend.app.model.entitys.Planeta;

public interface IPlanetaServiceDao extends CrudRepository<Planeta, Long>{

	@Query(value = "SELECT * FROM Planeta p ORDER BY p.contador DESC LIMIT 3", nativeQuery = true)
	public List<Planeta> findTop3();
	
}
