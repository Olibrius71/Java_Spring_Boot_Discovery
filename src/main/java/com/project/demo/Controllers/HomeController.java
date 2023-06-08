package com.project.demo.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && (Boolean) httpSession.getAttribute("loggedIn")) {
            return "home";
        }
        return "redirect:login";
    }
}