package com.ESD.steamed.game;

import com.ESD.steamed.review.ReviewCreateDTO;
import com.ESD.steamed.review.ReviewDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll(){
        return ResponseEntity.ok(gameService.getAll());
    }

    @PostMapping
    public ResponseEntity<GameDTO> create(@RequestBody GameCreateDTO gameCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.create(gameCreateDTO));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewDTO> createReviewForGame(@PathVariable Long id, @RequestBody ReviewCreateDTO reviewCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gameService.createReviewForGame(id, reviewCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.getById(id));
    }
}
