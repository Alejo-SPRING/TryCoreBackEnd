package com.trycore.backend.app.model.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.trycore.backend.app.model.entitys.Messages;

public interface IMessagesServiceDao extends CrudRepository<Messages, Long>{

	@Query("SELECT m FROM Messages m WHERE m.sendTo.id = :sendToId")
	List<Messages> findAllBySendTo(@Param("sendToId") Long sendToId);
	
}
