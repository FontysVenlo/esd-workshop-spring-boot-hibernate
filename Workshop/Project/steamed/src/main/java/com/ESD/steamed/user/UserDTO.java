package com.ESD.steamed.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/* A DTO class which is used to hide specific fields that you don't want to expose to the outside world
*  or to return calculated values. Basically its like an Entity tailored to the needs of the system consuming the request (The Frontend for example) */
@Data
@Setter
@Getter
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

}
