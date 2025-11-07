package com.ESD.steamed.userGame;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userGames")
public class UserGameController {

    private final UserGameService userGameService;

    public UserGameController(UserGameService userGameService) {this.userGameService = userGameService;}

    @PostMapping("/add")
    public ResponseEntity<UserGameDTO> addGameToLibrary(@Valid @RequestBody UserGameCreateDTO createDTO) {
        try {
            UserGameDTO updatedLibrary = userGameService.addGameToLibrary(createDTO);
            return new ResponseEntity<>(updatedLibrary, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /*@DeleteMapping("/{userId}/games/{gameId}")
    public ResponseEntity<UserGameDTO> removeGameFromLibrary(@PathVariable Long userId, @PathVariable Long gameId) {
        try {
            UserGameDTO updatedLibrary = userGameService.removeGameFromLibrary(userId, gameId);
            return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    /*@GetMapping("/users/{userId}")
    public ResponseEntity<UserGameDTO> getUserLibrary(@PathVariable Long userId) {
        try {
            UserGameDTO library = userGameService.getUserLibrary(userId);
            return new ResponseEntity<>(library, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity(new UserGameDTO(userId, Collections.emptyList()), HttpStatus.NOT_FOUND);
        }
    }*/

}