package com.ESD.steamed.review;

import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, GameRepository gameRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.gameRepository = gameRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> getAllByGameId(Long gameId) {
        List<Review> listOfReviews = reviewRepository.findAll();
        return reviewMapper.toDTOList(listOfReviews);
    }

    public ReviewDTO create(ReviewCreateDTO reviewCreateDTO) {
        Game game = gameRepository.findById(reviewCreateDTO.getGameId())
                .orElseThrow(() -> new ResourceNotFoundException("Game of Review not found"));
        return reviewMapper.toDto(reviewRepository.save(reviewMapper.toEntity(reviewCreateDTO, game)));
    }

    public ReviewDTO getById(Long id) {
        return reviewMapper.toDto(reviewRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review not found.")));
    }

}
