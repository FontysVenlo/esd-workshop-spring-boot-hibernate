package com.ESD.steamed.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserCreateDTO {

    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public UserCreateDTO( @NotNull String username, @NotNull String email, @NotNull String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
