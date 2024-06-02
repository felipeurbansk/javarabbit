package com.javarabbit.domain.messages.services;

import com.javarabbit.domain.users.dtos.UserResponseDTO;
import com.javarabbit.domain.users.models.User;
import com.javarabbit.infrastructure.persistence.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllMessagesService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> handler() {
        List<User> users = userRepository.findAllUserOrderedByIdDesc();

        return users.stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());
    }

}
