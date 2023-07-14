package com.project.demo.Controllers;


import com.project.demo.Entities.AppUser;
import com.project.demo.Entities.Game;
import com.project.demo.Repositories.AppUserRepository;
import com.project.demo.Repositories.GameRepository;
import com.project.demo.Services.AppUserService;
import com.project.demo.Services.GameService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public String viewGame() {
        return "game";
    }

    /**
     *
     * @param victory true si l'utilisateur a trouvé toutes les paires dans le temps imparti
     * @param totalTime le temps total de la partie (qu'elle soit gagnée ou perdue
     * @param timeToSeeCards le temps que l'utilisateur a eu pour voir les cartes avant que la partie commence
     * @param timeToWin le temps
     * @param nbPairsFound
     * @return
     */
    @PostMapping("/save-game-data")
    public String endGame(@RequestParam("victory") Boolean victory,
                          @RequestParam("totalTime") Float totalTime,
                          @RequestParam("timeToSeeCards") Float timeToSeeCards,
                          @RequestParam(value = "timeToWin", required = false) Float timeToWin,
                          @RequestParam(value = "nbPairsFound", required = false) Integer nbPairsFound,
                          HttpSession httpSession) {
        System.out.println(victory + "  " + totalTime + "  " + timeToSeeCards + "  " + timeToWin + "  " + "  " + nbPairsFound);
        Game newGame = null;
        AppUser currentUser = appUserService.getUserByNickname((String) httpSession.getAttribute("userNickname"));

        if (timeToWin != null) {
            newGame = new Game(currentUser,victory,totalTime,timeToSeeCards,timeToWin);
        }
        else {
            newGame = new Game(currentUser,victory,totalTime,timeToSeeCards,nbPairsFound);
        }

        gameService.addGameToGames(newGame);
        appUserService.addGameToUser(newGame, currentUser.getId());

        return "redirect:/";  // Cela ne redirige pas, c'est le code javascript qui redirige
    }
}
