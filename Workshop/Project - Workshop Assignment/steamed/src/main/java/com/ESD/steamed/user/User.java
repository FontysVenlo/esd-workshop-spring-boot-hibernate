package com.ESD.steamed.user;


import com.ESD.steamed.review.Review;
import com.ESD.steamed.userGame.UserGame;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "steamed_user")
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> review = new ArrayList<>();

    @NotNull
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserGame> libraryEntries = new ArrayList<>();

    public User() {
    }

    public User(@NotNull String username, @NotNull String email, @NotNull String password_hash) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
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

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public List<UserGame> getLibraryEntries() {
        return libraryEntries;
    }

    public void setLibraryEntries(List<UserGame> libraryEntries) {
        this.libraryEntries = libraryEntries;
    }
}
