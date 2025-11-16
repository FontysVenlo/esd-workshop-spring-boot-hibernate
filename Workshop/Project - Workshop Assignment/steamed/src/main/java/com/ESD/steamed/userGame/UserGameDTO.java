package com.ESD.steamed.userGame;

import com.ESD.steamed.game.GameDTO;
import com.ESD.steamed.user.User;

import java.time.LocalDateTime;

public class UserGameDTO {
    private Long id;
    private User user;
    private GameDTO gameDTO;
    private LocalDateTime purchaseDate;
    private LocalDateTime lastPlayed;
    private Long playTimeHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameDTO getGameDTO() {
        return gameDTO;
    }

    public void setGameDTO(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(LocalDateTime lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public Long getPlayTimeHours() {
        return playTimeHours;
    }

    public void setPlayTimeHours(Long playTimeHours) {
        this.playTimeHours = playTimeHours;
    }
}