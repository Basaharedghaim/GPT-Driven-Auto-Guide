package com.carservices.finalproject.service;

import com.carservices.finalproject.model.Messages;
import com.carservices.finalproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private  MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }
    public void saveMessage(Messages messages){
        messageRepository.save(messages);
    }
}
