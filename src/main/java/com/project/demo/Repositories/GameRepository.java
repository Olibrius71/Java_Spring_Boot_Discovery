package com.project.demo.Repositories;

import com.project.demo.Entities.AppUser;
import com.project.demo.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    @Query("select g from Game g where g.userPlaying.id = ?1")
    List<Game> findByUserPlayingId(@NonNull Integer userId);

    @Query("select g from Game g where g.userPlaying.nickname = ?1")
    List<Game> findByUserPlayingNickname(@NonNull String userNickname);

    @Override
    <G extends Game> G save(G entity);
}
