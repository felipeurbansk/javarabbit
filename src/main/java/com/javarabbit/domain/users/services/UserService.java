package com.javarabbit.domain.users.services;

import com.javarabbit.domain.users.dtos.CreateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UpdateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UserResponseDTO;
import com.javarabbit.domain.users.models.User;
import com.javarabbit.infrastructure.persistence.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAllUserOrderedByIdDesc();

        return users.stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserResponseDTO save(CreateUserRequestDTO userRequest) {
        User user = new User();

        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public UserResponseDTO update(Long id, UpdateUserRequestDTO userRequest) {
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

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
