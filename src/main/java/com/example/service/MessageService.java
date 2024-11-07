package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.exception.ClientError;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        if (!message.getMessageText().isBlank() && message.getMessageText().length()<=255){
            if (messageRepository.findByPostedBy(message.getPostedBy()) != null) {
                return messageRepository.save(message);
            }
        }
        throw new ClientError();
    }
}
