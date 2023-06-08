package com.project.demo.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.setAttribute("loggedIn",false);
        httpSession.removeAttribute("userNickname");

        return "redirect:login";
    }
}
