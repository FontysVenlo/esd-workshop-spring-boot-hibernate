package com.ESD.steamed.review;

import com.ESD.steamed.game.GameCreateDTO;
import com.ESD.steamed.game.GameDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviewsByGameId(@PathVariable Long gameId){
       return ResponseEntity.ok(reviewService.getAllByGameId(gameId));
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> create(@RequestBody ReviewCreateDTO reviewCreateDTO){
        return ResponseEntity.ok(reviewService.create(reviewCreateDTO));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReviewDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.getById(id));
    }

}
