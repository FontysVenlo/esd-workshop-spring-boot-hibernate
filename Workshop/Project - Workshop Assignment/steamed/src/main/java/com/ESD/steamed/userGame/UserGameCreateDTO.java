package com.ESD.steamed.userGame;

import jakarta.validation.constraints.NotNull;

public class UserGameCreateDTO {

    @NotNull(message = "Game ID cannot be null")
    private Long gameId;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}