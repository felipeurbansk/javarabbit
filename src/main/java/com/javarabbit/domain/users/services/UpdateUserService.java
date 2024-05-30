package com.javarabbit.domain.users.services;

import com.javarabbit.domain.users.dtos.UpdateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UserResponseDTO;
import com.javarabbit.domain.users.models.User;
import com.javarabbit.infrastructure.persistence.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO handler(Long id, UpdateUserRequestDTO userRequest) {
        User user = userRepository.findById(id).orElseThrow();

        if(userRequest.getUsername() != null) {
            user.setUsername(userRequest.getUsername());
        }
        if(userRequest.getEmail() != null) {
            user.setEmail(userRequest.getEmail());
        }

        if(userRequest.getPassword() != null && !userRequest.getPassword().isEmpty()) {
            user.setPassword(userRequest.getPassword());
        }

        User updatedUser = userRepository.save(user);

        return new UserResponseDTO(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getEmail());
    }
}
