package com.javarabbit.infrastructure.persistence.users;

import com.javarabbit.domain.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
