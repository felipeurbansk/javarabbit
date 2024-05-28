package com.javarabbit.domain.users.dtos;


public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;

    public UserResponseDTO() {}

    public UserResponseDTO(Long id, String username) {
        setId(id);
        setUsername(username);
    }

    public UserResponseDTO(Long id, String username, String email) {
        setId(id);
        setUsername(username);
        setEmail(email);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
