package com.ESD.steamed.userGame;

import com.ESD.steamed.exception.ResourceAlreadyExistsException;
import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameRepository;
import com.ESD.steamed.user.User;
import com.ESD.steamed.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserGameService {

    private final UserGameRepository userGameRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final UserGameMapper userGameMapper;

    public UserGameService(UserGameRepository userGameRepository, UserRepository userRepository, GameRepository gameRepository, UserGameMapper userGameMapper) {
        this.userGameRepository = userGameRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.userGameMapper = userGameMapper;
    }

    @Transactional
    public UserGameDTO addGameToLibrary(Long userId, UserGameCreateDTO createDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        Game game = gameRepository.findById(createDTO.getGameId())
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + createDTO.getGameId()));

        if (userGameRepository.existsByUser_IdAndGame_Id(user.getId(), game.getId())) {
            throw new ResourceAlreadyExistsException("Game with ID " + game.getId() + " is already in user's library.");
        }

        UserGame userGame = new UserGame();
        userGame.setUser(user);
        userGame.setGame(game);
        userGame.setPurchaseDate(LocalDateTime.now());

        return userGameMapper.toDto(userGameRepository.save(userGame));
    }

    /*@Transactional
    public UserGameDTO removeGameFromLibrary(Long userId, Long gameId) {
        Optional<UserGame> libraryEntry = userGameRepository.findByUser_IdAndGame_Id(userId, gameId);

        if (libraryEntry.isPresent()) {
            userGameRepository.delete(libraryEntry.get());
            return getUserLibrary(userId);
        } else {
            throw new EntityNotFoundException("Game with ID " + gameId + " not found in user " + userId + "'s library.");
        }
    }*/

    public List<UserGameDTO> getUserLibrary(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        List<UserGame> userGames = userGameRepository.findByUser_Id(userId);

        return userGames.stream().map(userGameMapper::toDto).toList();
    }


    public boolean isGameInLibrary(Long userId, Long gameId) {
        return userGameRepository.existsByUser_IdAndGame_Id(userId, gameId);
    }

}