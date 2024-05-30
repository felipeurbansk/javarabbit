package com.javarabbit.domain.users.services;

import com.javarabbit.domain.users.dtos.UserResponseDTO;
import com.javarabbit.domain.users.models.User;
import com.javarabbit.infrastructure.persistence.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO handler(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail());
    }
}
