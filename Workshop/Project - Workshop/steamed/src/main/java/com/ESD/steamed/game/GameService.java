package com.ESD.steamed.game;

import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.review.ReviewCreateDTO;
import com.ESD.steamed.review.ReviewDTO;
import com.ESD.steamed.review.ReviewMapper;
import com.ESD.steamed.review.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public List<GameDTO> getAll(){
        List <Game> listOfGames = gameRepository.findAll();
        return gameMapper.toDtoList(listOfGames);
    }

    public List<GameDTO> getAllWithLowerPrice(BigDecimal price){
        return gameMapper.toDtoList(gameRepository.findByPriceLessThan(price));
    }

    public GameDTO create(GameCreateDTO gameCreateDTO){
        return gameMapper.toDto(gameRepository.save(gameMapper.toEntity(gameCreateDTO)));
    }

    public GameDTO updateById(Long id, GameCreateDTO gameCreateDTO){
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + id));

        game.setDescription(gameCreateDTO.getDescription());
        game.setDeveloper(gameCreateDTO.getDeveloper());
        game.setTitle(gameCreateDTO.getTitle());
        game.setReleaseDate(gameCreateDTO.getReleaseDate());
        game.setPrice(gameCreateDTO.getPrice());
        return gameMapper.toDto(gameRepository.save(game));
    }

    public ReviewDTO createReviewForGame(Long gameId, ReviewCreateDTO reviewCreateDTO){
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + gameId));
        return reviewMapper.toDto(reviewRepository.save(reviewMapper.toEntity(reviewCreateDTO, game)));
    }

    public GameDTO getById(Long id){
        return gameMapper.toDto(gameRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + id)));
    }

}
