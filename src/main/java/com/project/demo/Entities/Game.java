package com.project.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    @NotNull
    @ManyToOne
    public AppUser userPlaying;

    @NotNull
    public Boolean victory;

    @NotNull
    public Float totalTime;

    @NotNull
    public Float timeToSeeCards;


    public Integer nbPairsFound;


    public Float timeToWin;


    public Game(@NotNull AppUser userPlaying, @NotNull Boolean victory, @NotNull Float totalTime, @NotNull Float timeToSeeCards) {
        this.userPlaying = userPlaying;
        this.victory = victory;
        this.totalTime = totalTime;
        this.timeToSeeCards = timeToSeeCards;
    }

    public Game(@NotNull AppUser userPlaying, @NotNull Boolean victory, @NotNull Float totalTime, @NotNull Float timeToSeeCards, Integer nbPairsFound) {
        this.userPlaying = userPlaying;
        this.victory = victory;
        this.totalTime = totalTime;
        this.timeToSeeCards = timeToSeeCards;
        this.nbPairsFound = nbPairsFound;
    }

    public Game(@NotNull AppUser userPlaying, @NotNull Boolean victory, @NotNull Float totalTime, @NotNull Float timeToSeeCards, Float timeToWin) {
        this.userPlaying = userPlaying;
        this.victory = victory;
        this.totalTime = totalTime;
        this.timeToSeeCards = timeToSeeCards;
        this.timeToWin = timeToWin;
    }
}