package com.javarabbit.infrastructure.persistence.chats;

import com.javarabbit.domain.chat.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
