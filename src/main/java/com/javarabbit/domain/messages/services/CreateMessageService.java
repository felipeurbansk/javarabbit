package com.javarabbit.domain.messages.services;

import com.javarabbit.domain.chat.models.Chat;
import com.javarabbit.domain.messages.dtos.CreateMessageRequestDTO;
import com.javarabbit.domain.messages.dtos.MessageResponseDTO;
import com.javarabbit.domain.messages.models.Message;
import com.javarabbit.domain.users.dtos.CreateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UserResponseDTO;
import com.javarabbit.domain.users.models.User;
import com.javarabbit.infrastructure.persistence.chats.ChatRepository;
import com.javarabbit.infrastructure.persistence.messages.MessageRepository;
import com.javarabbit.infrastructure.persistence.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateMessageService {

    @Autowired
    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private ChatRepository chatRepository;

    public MessageResponseDTO handler(CreateMessageRequestDTO messageRequest) {
        User owner = userRepository.findById(messageRequest.getOwnerId()).orElseThrow();
        Optional<User> receiver = userRepository.findById(messageRequest.getReceiverId());
        Optional<Chat> chat = chatRepository.findById(messageRequest.getChatId());

        if (chat.isEmpty() && receiver.isEmpty()) {
            throw new RuntimeException("Chat ou destinatário não encontrado.");
        }

        if (chat.isEmpty()) {
            Chat newChat = new Chat();
            newChat.setParticipants(List.of(owner, receiver.get()));
            chat = Optional.of(chatRepository.save(newChat));
        }

        Message message = new Message();
        message.setOwner(owner);
        message.setChat(chat.get());
        message.setMessage(messageRequest.getMessage());

        Message savedMessage = messageRepository.save(message);

        return new MessageResponseDTO(savedMessage.getId(), savedMessage.getChat().getId(), savedMessage.getOwner().getId(), savedMessage.getMessage());
    }
}
