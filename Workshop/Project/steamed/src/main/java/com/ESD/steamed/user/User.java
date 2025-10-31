package com.ESD.steamed.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "steamed_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password_hash;




    public User(@NotNull String username, @NotNull String email, @NotNull String password_hash) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
    }
}
