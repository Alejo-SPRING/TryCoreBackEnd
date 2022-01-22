package com.trycore.backend.app.pojos;

import com.trycore.backend.app.model.entitys.Messages;

public class MessagePojoInfo {

	private String message;
	private String messageSendFrom;

	public MessagePojoInfo(Messages message) {
		this.message = message.getMessage();
		this.messageSendFrom = message.getSendFrom().getNombre();
	}
	
	public String getMessage() {
		return message;
	}

	public String getMessageSendFrom() {
		return messageSendFrom;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageSendFrom(String messageSendFrom) {
		this.messageSendFrom = messageSendFrom;
	}

}
