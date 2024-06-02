package com.javarabbit.domain.chat.services;

import com.javarabbit.domain.chat.dtos.ChatResponseDTO;
import com.javarabbit.domain.chat.dtos.CreateChatRequestDTO;
import com.javarabbit.domain.chat.models.Chat;
import com.javarabbit.domain.users.models.User;
import com.javarabbit.infrastructure.persistence.chats.ChatRepository;
import com.javarabbit.infrastructure.persistence.users.UserRepository;
import org.springframework.http.ResponseEntity;

public class CreateChatService {
    private ChatRepository chatRepository;
    private UserRepository userRepository;

    public ResponseEntity<ChatResponseDTO> handler(CreateChatRequestDTO chatRequest) {
        User owner = userRepository.findById(chatRequest.getOwnerId()).orElseThrow();
        User receiver = userRepository.findById(chatRequest.getReceiverId()).orElseThrow();

        Chat chat = new Chat();
    }
}
