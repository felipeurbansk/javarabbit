package com.javarabbit.domain.messages.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateMessageRequestDTO {

    @NotBlank(message = "ownerId é obrigatório")
    private Long ownerId;

    @NotBlank(message = "chatId é obrigatório")
    private Long chatId;

    private Long receiverId;
    
    @NotBlank(message = "message é obrigatório")
    private String message;


    public CreateMessageRequestDTO(Long ownerId, Long chatId, String message) {
        setOwnerId(ownerId);
        setChatId(chatId);
        setMessage(message);
    }

    public @NotBlank(message = "ownerId é obrigatório") Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(@NotBlank(message = "ownerId é obrigatório") Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public @NotBlank(message = "chatId é obrigatório") Long getChatId() {
        return chatId;
    }

    public void setChatId(@NotBlank(message = "chatId é obrigatório") Long chatId) {
        this.chatId = chatId;
    }

    public @NotBlank(message = "message é obrigatório") String getMessage() {
        return message;
    }

    public void setMessage(@NotBlank(message = "message é obrigatório") String message) {
        this.message = message;
    }
}
