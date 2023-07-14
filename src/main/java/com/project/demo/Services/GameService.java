package com.project.demo.Services;

import com.project.demo.Entities.Game;
import com.project.demo.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    /*
    public ArrayList<Game> getAllGamesOfUser(Integer idOfUser) {
        ArrayList<Game> gamesOfUser = (ArrayList<Game>) gameRepository.findAllBy(idOfUser);
        return gamesOfUser;
    }
    */
    public void addGameToGames(Game newGame) {
        gameRepository.save(newGame);
    }
}
