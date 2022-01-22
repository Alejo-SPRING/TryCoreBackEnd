package com.trycore.backend.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycore.backend.app.exceptions.ValidationException;
import com.trycore.backend.app.model.entitys.Messages;
import com.trycore.backend.app.model.entitys.Planeta;
import com.trycore.backend.app.model.services.IMessagesServiceDao;
import com.trycore.backend.app.model.services.IPlanetaServiceDao;
import com.trycore.backend.app.pojos.MessagePojoInfo;

@Service
public class MessagesServiceImpl implements IMessagesService{
	
	@Autowired
	private IMessagesServiceDao messagesServiceDao;
	@Autowired
	private IPlanetaServiceDao planetaServiceDao;
	
	@Override
	public List<MessagePojoInfo> getAllMesageBySendTo(Long planetId){
		List<Messages> messages = messagesServiceDao.findAllBySendTo(planetId);
		List<MessagePojoInfo> response = new ArrayList<>();
		for(Messages message : messages) {
			response.add(new MessagePojoInfo(message));
		}
		return response;
	}
	
	@Override
	public void saveMessage(String message, Long sendFromId, Long senToId) throws ValidationException {
		String[] binaryData = message.split(" ");
		String messageDecode = "";
		for(String binary : binaryData) {
			int decimal =  binaryToDecimal(binary);
			char letra = (char) decimal;
			messageDecode += letra; 
		}
		Planeta sendForm = planetaServiceDao.findById(sendFromId).orElseThrow(() -> new ValidationException("¡Is planet message from not exist!!"));
		Planeta sendTo = planetaServiceDao.findById(senToId).orElseThrow(() -> new ValidationException("¡Is planet message to not exist!!"));
		Messages messagePojo = new Messages();
		messagePojo.setSendFrom(sendForm);
		messagePojo.setSendTo(sendTo);
		messagePojo.setMessage(messageDecode);
		messagesServiceDao.save(messagePojo);
	}
	
	private Integer binaryToDecimal(String binary) {
		int decimal = 0;
		int position = 0;
		for(int i = binary.length() - 1; i >= 0; i --) {
			short digit = 1;
			if(binary.charAt(i) == '0') {
				digit = 0;
			}
			double multiple = Math.pow(2, position);
			decimal += digit * multiple;
			position ++;
		}
		return decimal;
	}
	
}
