package com.ESD.steamed.userGame;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGameDTO {
    private Long id;
    private User user;
    private Game game;
    private LocalDateTime purchaseDate;
    private LocalDateTime lastPlayed;
    private Long playTimeHours;
}