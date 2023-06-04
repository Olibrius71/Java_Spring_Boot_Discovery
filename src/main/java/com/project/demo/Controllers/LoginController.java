package com.project.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String Home() {
        return "login";
    }

    @PostMapping("/login")
    public String Login() {
        return "home";
    }
}
