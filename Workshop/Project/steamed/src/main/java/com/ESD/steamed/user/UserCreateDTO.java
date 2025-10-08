package com.ESD.steamed.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/* A DTO class which is used to hide specific fields that you don't want to expose to the outside world
*  or to return calculated values. Basically its like an Entity tailored to the needs of the system consuming the request (The Frontend for example) */
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
