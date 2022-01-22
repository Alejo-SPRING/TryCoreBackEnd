package com.trycore.backend.app.services;

import java.util.List;

import com.trycore.backend.app.exceptions.ValidationException;
import com.trycore.backend.app.pojos.MessagePojoInfo;

public interface IMessagesService {

	void saveMessage(String message, Long sendFromId, Long senToId) throws ValidationException;

	List<MessagePojoInfo> getAllMesageBySendTo(Long planetId);

}
