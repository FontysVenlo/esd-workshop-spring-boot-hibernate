package com.ESD.steamed.game;

import com.ESD.steamed.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;


    public List<Game> getAll(){
        List <Game> listOfGames = gameRepository.findAll();
        System.out.println(listOfGames);
        return listOfGames;
    }

    public GameDTO create(GameCreateDTO gameCreateDTO){
        System.out.println("GAME SERVICE" + gameCreateDTO);
        return gameMapper.toDto(gameRepository.save(gameMapper.toEntity(gameCreateDTO)));
    }

    public GameDTO getById(Long id){
        return gameMapper.toDto(gameRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Game not found.")));
    }
}
