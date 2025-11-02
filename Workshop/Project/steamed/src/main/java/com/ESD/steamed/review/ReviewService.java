package com.ESD.steamed.review;

import com.ESD.steamed.exception.ResourceNotFoundException;
import com.ESD.steamed.game.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;
    private final ReviewMapper reviewMapper;


    public List<ReviewDTO> getAllByGameId(Long gameId){
        List<Review> listOfReviews = reviewRepository.findAll();
        return reviewMapper.toDTOList(listOfReviews);
    }

    public ReviewDTO create(ReviewCreateDTO reviewCreateDTO){
        Game game = gameRepository.findById(reviewCreateDTO.getGameId())
                .orElseThrow(() -> new ResourceNotFoundException("Game of Review not found"));
        return reviewMapper.toDto(reviewRepository.save(reviewMapper.toEntity(reviewCreateDTO, game)));
    }

    public ReviewDTO getById(Long id){
        return reviewMapper.toDto(reviewRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review not found.")));
    }

}
