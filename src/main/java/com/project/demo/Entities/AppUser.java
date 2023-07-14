package com.project.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    @NotNull
    @Column(unique = true)
    @Email
    public String mailAddress;

    @NotNull
    @Column(unique = true)
    @Size(min = 6)
    public String nickname;

    @NotNull
    @Column
    @Size(min = 10)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
             message = "Le mot de pass doit contenir au moins une lettre MAJUSCULE, une lettre minuscule et un chiffre")
    public String password;


    @OneToMany(mappedBy = "userPlaying")
    public List<Game> gamesPlayed;


    public AppUser(String mailAddress,
                String nickname,
                String password) {
        this.mailAddress = mailAddress;
        this.nickname = nickname;
        this.password = password;
        this.gamesPlayed = new ArrayList<Game>();
    }


    public void addGame(Game newGame) {
        gamesPlayed.add(newGame);
    }


}
