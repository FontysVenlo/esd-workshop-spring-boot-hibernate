package com.ESD.steamed.game;

import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.review.ReviewCreateDTO;
import com.ESD.steamed.review.ReviewDTO;
import com.ESD.steamed.review.ReviewMapper;
import com.ESD.steamed.review.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;


    public List<Game> getAll(){
        List <Game> listOfGames = gameRepository.findAll();
        System.out.println(listOfGames);
        return listOfGames;
    }

    public GameDTO create(GameCreateDTO gameCreateDTO){
        return gameMapper.toDto(gameRepository.save(gameMapper.toEntity(gameCreateDTO)));
    }

    public ReviewDTO createReviewForGame(Long gameId, ReviewCreateDTO reviewCreateDTO){
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found."));

        return reviewMapper.toDto(reviewRepository.save(reviewMapper.toEntity(reviewCreateDTO, game)));
    }

    public GameDTO getById(Long id){
        return gameMapper.toDto(gameRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Game not found.")));
    }

}
