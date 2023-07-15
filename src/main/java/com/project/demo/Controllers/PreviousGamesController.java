package com.project.demo.Controllers;

import com.project.demo.Entities.Game;
import com.project.demo.Services.AppUserService;
import com.project.demo.Services.GameService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PreviousGamesController {

    @Autowired
    private GameService gameService;

    @GetMapping("/previous-games")
    public String viewPreviousGames(Model model, HttpSession httpSession) {
        List<Game> gamesOfUser = gameService.getAllGamesOfUser((String) httpSession.getAttribute("userNickname"));
        model.addAttribute("gamesOfUser", gamesOfUser);
        return "previous-games";
    }
}
