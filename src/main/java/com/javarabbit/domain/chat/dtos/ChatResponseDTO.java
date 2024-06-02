package com.javarabbit.domain.chat.dtos;

import com.javarabbit.domain.messages.dtos.MessageResponseDTO;
import com.javarabbit.domain.users.models.User;

import java.util.List;

public class ChatResponseDTO {

    private Long id;
    private User owner;
    private User receiver;
    private List<MessageResponseDTO> messages;

    public ChatResponseDTO(Long id, User owner, User receiver) {
        setId(id);
        setOwner(owner);
        setReceiver(receiver);
    }

    public ChatResponseDTO(Long id, User owner, User receiver, List<MessageResponseDTO> messages) {
        setId(id);
        setOwner(owner);
        setReceiver(receiver);
        setMessages(messages);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public List<MessageResponseDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageResponseDTO> messages) {
        this.messages = messages;
    }
}
