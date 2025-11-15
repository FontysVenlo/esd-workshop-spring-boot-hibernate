package com.ESD.steamed.game;

import com.ESD.steamed.review.ReviewCreateDTO;
import com.ESD.steamed.review.ReviewDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* @ ANNOTATIONS:
*
* @RestController -> Used before a Controller Classes to tell Spring that this is a REST Controller. Spring then automatically
* manages everything needed for a REST controller in the background.
*
* @RequestMapping("/games") -> Used before Controller Classes to tell Spring that incoming requests to the specified path
* within the parameter need to be wired to this Controller.
*
* @GetMapping() -> Used before a method within a Controller to wire an incoming GET request.
* @PostMapping() -> Used before a method within a Controller to wire an incoming POST request.
*
* @RequestBody -> Used before a parameter values of POST request to Specify the Datatype needed in the request.
*   example: public ResponseEntity<GameDTO> create(@RequestBody GameCreateDTO gameCreateDTO)
*
*
*
* */

public class GameController {

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll(){
        return ResponseEntity.ok();
    }

    /*Todo: write this method*/
    public ResponseEntity<GameDTO>  create(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.getById(id));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewDTO> createReviewForGame(@PathVariable Long id, @RequestBody ReviewCreateDTO reviewCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gameService.createReviewForGame(id, reviewCreateDTO));
    }


}
