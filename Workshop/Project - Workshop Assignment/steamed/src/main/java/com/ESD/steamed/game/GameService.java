package com.ESD.steamed.game;

import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.review.ReviewCreateDTO;
import com.ESD.steamed.review.ReviewDTO;
import com.ESD.steamed.review.ReviewMapper;
import com.ESD.steamed.review.ReviewRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public List<GameDTO> getAll(){
        List <Game> listOfGames = gameRepository.findAll();
        return gameMapper.toDtoList(listOfGames);
    }

    /* Todo: Part 2.4 => call the Repository with your own custom method*/
    public List<GameDTO> getAllWithLowerPrice(BigDecimal maxPrice){
        /* Call the Repository and reuturn the List of games with a lower price than maxPrice*/
        return new ArrayList<GameDTO>();
    }

    public GameDTO create(GameCreateDTO gameCreateDTO){
        return gameMapper.toDto(gameRepository.save(gameMapper.toEntity(gameCreateDTO)));
    }

    public GameDTO getById(Long id){
        /*
        *  Todo: Part 2.1 => Implement this method.
        *  Call the gameRepository to retrieve a Game with its id.
        *  Handle the Optional<Game> and throw a ResourceNotFoundException if its not found.
        *  Exception prints: "User not found with ID: " + id"
        */
        return new GameDTO();
    }

    /* Todo: part 2.2 => Implement this method */
    public GameDTO updateById(Long id, GameCreateDTO gameCreateDTO){
        /* tipp: Get the existing game from the repository and set its values to the ones from the new
         *       GameCreateDTO then save the changed Entity and return it. Spring will automatically handle everything
         *       in the background.
         *
         */
        return new GameDTO();
    }

    public ReviewDTO createReviewForGame(Long gameId, ReviewCreateDTO reviewCreateDTO){
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + gameId));

        return reviewMapper.toDto(reviewRepository.save(reviewMapper.toEntity(reviewCreateDTO, game)));
    }

}
