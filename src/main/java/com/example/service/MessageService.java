package com.example.service;

import java.util.List;

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

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Integer messageId) {
        return messageRepository.findByMessageId(messageId);
    }

    public Integer deleteMessageById(Integer messageId) {
        Message message = messageRepository.findByMessageId(messageId);

        if (message != null) {
            messageRepository.deleteById(messageId);
            return 1;
        }

        return null;
    }
}
