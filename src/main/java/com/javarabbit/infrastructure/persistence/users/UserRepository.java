package com.javarabbit.infrastructure.persistence.users;

import com.javarabbit.domain.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users ORDER BY id ASC", nativeQuery = true)
    List<User> findAllUserOrderedByIdDesc();

}
