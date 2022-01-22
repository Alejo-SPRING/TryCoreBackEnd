package com.trycore.backend.app.pojos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MessagePojo {

	@NotNull(message = "¡Is required i message!")
	@NotEmpty(message = "¡Is required i message!")
	@Pattern(regexp = "[01 ]*", message = "¡Message is not binary!")
	private String message;
	@NotNull(message = "¡Is required i planet message from id!")
	private Long planetMessageFromId;
	@NotNull(message = "¡Is required i planet message send id!")
	private Long planetMessageToId;

	public String getMessage() {
		return message;
	}

	public Long getPlanetMessageFromId() {
		return planetMessageFromId;
	}

	public Long getPlanetMessageToId() {
		return planetMessageToId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPlanetMessageFromId(Long planetMessageFromId) {
		this.planetMessageFromId = planetMessageFromId;
	}

	public void setPlanetMessageToId(Long planetMessageToId) {
		this.planetMessageToId = planetMessageToId;
	}

}
