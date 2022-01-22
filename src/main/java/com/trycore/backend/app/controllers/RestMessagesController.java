package com.trycore.backend.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.backend.app.exceptions.ValidationException;
import com.trycore.backend.app.pojos.MessagePojo;
import com.trycore.backend.app.services.IMessagesService;

@RestController
@RequestMapping("/messages")
public class RestMessagesController {

	@Autowired
	private IMessagesService messageService;
	private Map<String, Object> body;

	@GetMapping("/findAll/{planetId}")
	private ResponseEntity<Object> findAllBySendTo(@PathVariable Long planetId){
		try {
			return new ResponseEntity<>(messageService.getAllMesageBySendTo(planetId), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			body = new HashMap<>();
			body.put("error", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/send")
	private ResponseEntity<Object> sendMessage(@Valid @RequestBody MessagePojo message, BindingResult result) {
		if (result.hasErrors()) {
			List<String> messages = result.getFieldErrors().stream()
					.map((m) -> m.getField() + ":" + m.getDefaultMessage()).collect(Collectors.toList());
			return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
		}
		try {
			messageService.saveMessage(message.getMessage(), message.getPlanetMessageFromId(), message.getPlanetMessageToId());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ValidationException e) {
			e.printStackTrace();
			body = new HashMap<>();
			body.put("error", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
