package com.javarabbit.domain.users.services;

import com.javarabbit.domain.users.models.User;
import com.javarabbit.infrastructure.persistence.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@Service
public class DeleteUserService {

    @Autowired
    private UserRepository userRepository;

    public void handler(Long id) {
        Optional<User> user = userRepository.findById(id);

        System.out.println("User found: " + user.isPresent());

        if(user.isEmpty()) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(user.get().getId());
    }
}
