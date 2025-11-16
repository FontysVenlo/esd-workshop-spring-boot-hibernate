package com.ESD.steamed.user;

import jakarta.validation.constraints.NotNull;

public class UserDTO {

    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String email;

    public UserDTO(Long id, @NotNull String username, @NotNull String email) {
        this.id = id;
        this.username = username;
        this.email = email;
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
