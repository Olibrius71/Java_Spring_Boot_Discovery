package com.project.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

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
                          @RequestParam(value = "nbPairsFound", required = false) Integer nbPairsFound) {
        System.out.println(victory + "  " + totalTime + "  " + timeToSeeCards + "  " + timeToWin + "  " + "  " + nbPairsFound);
        return "redirect:/";
    }
}
