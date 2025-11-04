package com.ESD.steamed.game;

import com.ESD.steamed.review.ReviewCreateDTO;
import com.ESD.steamed.review.ReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAll(){
       return ResponseEntity.status(HttpStatus.CREATED).body(gameService.getAll());
    }

    @PostMapping
    public ResponseEntity<GameDTO> create(@RequestBody GameCreateDTO gameCreateDTO){
        return ResponseEntity.ok(gameService.create(gameCreateDTO));
    }

    @PostMapping(path = "/{id}/reviews")
    public ResponseEntity<ReviewDTO> createReviewForGame(@PathVariable Long id, @RequestBody ReviewCreateDTO reviewCreateDTO){
        return ResponseEntity.ok(gameService.createReviewForGame(id,reviewCreateDTO));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.getById(id));
    }



}
