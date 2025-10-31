package com.ESD.steamed.review;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ReviewMapper {
    private final GameMapper gameMapper;

    public ReviewDTO toDto(Review review) {
        if (review == null) return null;

        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setTitle(review.getTitle());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setCreatedAt(review.getCreated_at());
        if (review.getGame() != null) {
            dto.setGameDTO(gameMapper.toDto(review.getGame()));
        }
        return dto;
    }

    public Review toEntity(ReviewCreateDTO reviewCreateDTO, Game game) {
        if (reviewCreateDTO == null) return null;

        Review review = new Review();
        review.setTitle(reviewCreateDTO.getTitle());
        review.setRating(reviewCreateDTO.getRating());
        review.setComment(reviewCreateDTO.getComment());
        review.setCreated_at(reviewCreateDTO.getCreatedAt());
        review.setGame(game);
        return review;
    }

    public List<Review> toEntityList(List<ReviewCreateDTO> reviewCreateDTOList, Game game) {
        return reviewCreateDTOList.stream()
                .map(dto -> toEntity(dto, game))
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> toDTOList(List<Review> reviewList) {
        return reviewList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
