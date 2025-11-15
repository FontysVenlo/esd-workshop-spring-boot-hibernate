package com.ESD.steamed.userGame;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGameCreateDTO {

    @NotNull(message = "Game ID cannot be null")
    private Long gameId;
}