/*
package com.ESD.steamed.mapper;

import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameRepository;
import com.ESD.steamed.library.UserGame;
import com.ESD.steamed.library.UserGameRepository;
import com.ESD.steamed.review.Review;
import com.ESD.steamed.review.ReviewRepository;
import com.ESD.steamed.user.User;
import com.ESD.steamed.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class IdToEntityMapper {

    private final GameRepository gameRepository;
    private final UserGameRepository userGameRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public IdToEntityMapper(GameRepository gameRepository, UserGameRepository userGameRepository, ReviewRepository reviewRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userGameRepository = userGameRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    private Game gameIdToEntity(Long id){
        return gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game not found!"));
    }
    private UserGame UserGameIdToEntity(Long id){
        return userGameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserGame not found!"));
    }
    private Review ReviewIdToEntity(Long id){
        return reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found!"));
    }
    private User UserIdToEntity(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }
}
*/
