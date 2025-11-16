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
* manages everything needed for a REST controller in the background. (JSON serialization and HTTP responses.)
*
* @RequestMapping("/games") -> Used before Controller Classes to tell Spring that incoming requests to the specified path
* need to be wired to this Controller. (defines a base URL path for all endpoints inside this controller.)
*
 * @GetMapping() -> Used on a method to handle HTTP GET requests to the mapped path.
 * @PostMapping() -> Used on a method to handle HTTP POST requests to the mapped path.
 * @PutMapping() -> Used on a method to handle HTTP PUT requests to the mapped path.
*
 * @PathVariable -> Used on a method parameter to bind a path variable from the URL to the parameter.
 *                  Example: /games/{id} -> @PathVariable Long id
 *
 * @RequestBody -> Used on a method parameter to bind the JSON request body to a Java object.
 *                 Example: public ResponseEntity<ReviewDTO> create(@RequestBody ReviewCreateDTO reviewCreateDTO)
 *
 * @RequestParam -> Used on a method parameter to bind a query parameter from the URL to a variable.
 *                  Example: /games?maxPrice=20 -> @RequestParam BigDecimal maxPrice
 *                  Common use cases: filtering, sorting, pagination, optional parameters.
*
*
* */
/* Todo: Part 1.2 => Make Sure Spring knows this is a RestController and how to map the incoming HTTP path to this one*/
public class GameController {

    /* Todo: Part 1.2 => inject the GameService into this class */

    /* Todo: Part 1.3 => call the service to retrieve all games */
    /* Todo: Part 2.5 => Change the method so that it recieves a Bigdecimal maxPrice  */
    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll(){
        return ResponseEntity.ok(null);
    }


    /* Todo: Part 1.4 => write this method */
    public ResponseEntity<GameDTO>  create(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.getById(id));
    }

    /* Todo: Part 2.2 => write this method */
    /*
     *  Use a PutMapping to Update an existing game with new values using an existing Id and a new GameCreateDTO
     *  note: In practice you could also create a GameUpdateDTO to make sure only certain fields are updatable.
    */
    public ResponseEntity<GameDTO> updateById(){
        return ResponseEntity.ok(null);
    }

    /* @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewDTO> createReviewForGame(@PathVariable Long id, @RequestBody ReviewCreateDTO reviewCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gameService.createReviewForGame(id, reviewCreateDTO));
    } */


}
