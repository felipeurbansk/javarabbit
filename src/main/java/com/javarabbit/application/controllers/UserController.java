package com.javarabbit.application.controllers;

import com.javarabbit.domain.users.dtos.CreateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UpdateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UserResponseDTO;
import com.javarabbit.domain.users.models.User;
import com.javarabbit.domain.users.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private FindAllUsersService findAllUsers;
    @Autowired
    private GetUserByIdService getUserByIdService;
    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private UpdateUserService updateUserService;
    @Autowired
    private DeleteUserService deleteUserService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> userResponse = findAllUsers.handler();

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(getUserByIdService.handler(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody CreateUserRequestDTO user) {
        return new ResponseEntity<>(createUserService.handler(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequestDTO userData) {
        return new ResponseEntity<>(updateUserService.handler(id, userData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        deleteUserService.handler(id);

        return ResponseEntity.noContent().build();
    }
}
