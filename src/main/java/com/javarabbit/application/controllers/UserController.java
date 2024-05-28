package com.javarabbit.application.controllers;

import com.javarabbit.domain.users.dtos.CreateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UpdateUserRequestDTO;
import com.javarabbit.domain.users.dtos.UserResponseDTO;
import com.javarabbit.domain.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> userResponse = userService.findAll();

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody CreateUserRequestDTO user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequestDTO userData) {
        return new ResponseEntity<>(userService.update(id, userData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if(userService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
