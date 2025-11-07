package com.ESD.steamed.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
