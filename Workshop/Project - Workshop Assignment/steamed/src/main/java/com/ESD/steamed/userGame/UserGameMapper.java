package com.ESD.steamed.userGame;

import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameMapper;
import com.ESD.steamed.game.GameRepository;
import com.ESD.steamed.user.User;
import com.ESD.steamed.user.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserGameMapper {

    private final GameMapper gameMapper;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public UserGameMapper(GameMapper gameMapper, GameRepository gameRepository, UserRepository userRepository) {
        this.gameMapper = gameMapper;
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    public UserGameDTO toDto(UserGame userGame) {

        UserGameDTO dto = new UserGameDTO();
        dto.setId(userGame.getId());
        dto.setGameDTO(gameMapper.toDto(userGame.getGame()));
        dto.setUser(userGame.getUser());
        dto.setLastPlayed(userGame.getLastPlayed());
        dto.setPurchaseDate(userGame.getPurchaseDate());
        dto.setPlayTimeHours(userGame.getPlayTimeHours());
        return dto;
    }

    public UserGame toEntity(UserGameCreateDTO dto, User user) {
        Game game = gameRepository.findById(dto.getGameId()).orElseThrow(() -> new ResourceNotFoundException("Game not found."));
        if (dto == null) return null;

        UserGame entry = new UserGame();
        entry.setUser(user);
        entry.setGame(game);
        entry.setPurchaseDate(LocalDateTime.now());
        entry.setPlayTimeHours(0L);
        entry.setLastPlayed(null);
        return entry;
    }

}
