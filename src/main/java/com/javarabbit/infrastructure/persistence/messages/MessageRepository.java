package com.javarabbit.infrastructure.persistence.messages;

import com.javarabbit.domain.messages.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT * FROM messages ORDER BY id ASC", nativeQuery = true)
    List<Message> findByChatIdOrderByTimestampAsc(Long chatId);
}
