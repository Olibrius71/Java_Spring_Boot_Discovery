package com.project.demo.Controllers;


import com.project.demo.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AppUserService appUserService;


    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }

    @PostMapping("/try-login")
    public String tryLogin(@RequestParam("nickname") String nickname,
                        @RequestParam("password") String password,
                        Model model) {
        if (appUserService.checkIfExistsAndPasswordCorrect(nickname,password)) {
            return "home";
        }
        model.addAttribute("wrongAccountInfo","Le Nom d'Utilisateur ou le Mot de Passe est incorrect");
        return "login";
    }

}
