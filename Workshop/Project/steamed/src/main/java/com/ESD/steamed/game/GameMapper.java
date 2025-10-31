package com.ESD.steamed.game;

import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameDTO toDto(Game game) {
        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setTitle(game.getTitle());
        dto.setDescription(game.getDescription());
        dto.setPrice(game.getPrice());
        dto.setReleaseDate(game.getReleaseDate());
        dto.setDeveloper(game.getDeveloper());
        return dto;
    }

    public Game toEntity(GameCreateDTO gameCreateDTO) {
        Game game = new Game();
        game.setTitle(gameCreateDTO.getTitle());
        game.setDescription(gameCreateDTO.getDescription());
        game.setPrice(gameCreateDTO.getPrice());
        game.setReleaseDate(gameCreateDTO.getReleaseDate());
        game.setDeveloper(gameCreateDTO.getDeveloper());
        return game;
    }
}
