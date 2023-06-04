package com.project.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home(Model model) {
        model.addAttribute("projectTitle","Spring Boot Discovery Project");
        model.addAttribute("userName","Utilisateur");
        return "home";
    }
}