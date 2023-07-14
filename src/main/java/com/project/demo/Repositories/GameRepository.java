package com.project.demo.Repositories;

import com.project.demo.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {


  //  List<Game> findAllBy(Integer idOfUser);

    @Override
    <G extends Game> G save(G entity);
}
