package com.ESD.steamed.game;

import com.ESD.steamed.review.ReviewCreateDTO;
import com.ESD.steamed.review.ReviewDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll(@RequestParam(required = false) BigDecimal maxPrice) {
        if (maxPrice != null) {
            return ResponseEntity.ok(gameService.getAllWithLowerPrice(maxPrice));
        }
        return ResponseEntity.ok(gameService.getAll());
    }

    @PostMapping
    public ResponseEntity<GameDTO> create(@Valid @RequestBody GameCreateDTO gameCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.create(gameCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> updateById(@Valid @PathVariable Long id, @RequestBody GameCreateDTO gameCreateDTO){
        return ResponseEntity.ok(gameService.updateById(id, gameCreateDTO));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewDTO> createReviewForGame(@Valid @PathVariable Long id, @RequestBody ReviewCreateDTO reviewCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gameService.createReviewForGame(id, reviewCreateDTO));
    }


}
