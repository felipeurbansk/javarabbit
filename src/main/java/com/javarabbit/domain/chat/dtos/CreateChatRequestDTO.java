package com.javarabbit.domain.chat.dtos;

public class CreateChatRequestDTO {

        private Long ownerId;
        private Long receiverId;

        public CreateChatRequestDTO(Long ownerId, Long receiverId) {
            setOwnerId(ownerId);
            setReceiverId(receiverId);
        }

        public Long getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Long ownerId) {
            this.ownerId = ownerId;
        }

        public Long getReceiverId() {
            return receiverId;
        }

        public void setReceiverId(Long receiverId) {
            this.receiverId = receiverId;
        }
}
