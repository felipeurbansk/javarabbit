package com.javarabbit.domain.messages.dtos;


public class MessageResponseDTO {

    private Long id;
    private Long chatId;
    private Long ownerId;
//    private Long receiverId;
    private String message;

    public MessageResponseDTO(Long id, Long chatId, Long ownerId, String message) {
        setId(id);
        setChatId(chatId);
        setOwnerId(ownerId);
        setMessage(message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

//    public Long getReceiverId() {
//        return receiverId;
//    }
//
//    public void setReceiverId(Long receiverId) {
//        this.receiverId = receiverId;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
