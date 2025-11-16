package com.ESD.steamed.user;

import jakarta.validation.constraints.NotNull;

public class UserCreateDTO {

    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public UserCreateDTO(@NotNull String username, @NotNull String email, @NotNull String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
