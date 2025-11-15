package com.ESD.steamed.userGame;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userGames")
public class UserGameController {

    private final UserGameService userGameService;

    public UserGameController(UserGameService userGameService) {
        this.userGameService = userGameService;
    }

    @PostMapping("/users/{id}/games")
    public ResponseEntity<UserGameDTO> addGameToLibrary(@Valid @PathVariable Long id, @RequestBody UserGameCreateDTO createDTO) {
        UserGameDTO updatedLibrary = userGameService.addGameToLibrary(id, createDTO);
        return new ResponseEntity<>(updatedLibrary, HttpStatus.CREATED);
    }

    /*@DeleteMapping("/{id}/games/{gameId}")
    public ResponseEntity<?> removeGameFromLibrary(@PathVariable Long id, @PathVariable Long gameId) {
        try {
            UserGameDTO updatedLibrary = userGameService.removeGameFromLibrary(id, gameId);
            return ResponseEntity.ok(updatedLibrary);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }*/

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserLibrary(@PathVariable Long id) {
        List<UserGameDTO> library = userGameService.getUserLibrary(id);
        return ResponseEntity.ok(library);
    }
}
