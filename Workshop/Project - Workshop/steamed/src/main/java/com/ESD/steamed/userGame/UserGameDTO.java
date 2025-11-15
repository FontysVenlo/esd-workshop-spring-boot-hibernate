package com.ESD.steamed.userGame;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameDTO;
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
    private GameDTO gameDTO;
    private LocalDateTime purchaseDate;
    private LocalDateTime lastPlayed;
    private Long playTimeHours;
}