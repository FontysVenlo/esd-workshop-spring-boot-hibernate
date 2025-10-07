package com.ESD.steamed.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll(){
        List <Game> listOfGames = gameRepository.findAll();
        System.out.println(listOfGames);
        return listOfGames;
    }
}
