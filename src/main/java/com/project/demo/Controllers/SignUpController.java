package com.project.demo.Controllers;


import com.project.demo.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/sign-up")
    public String viewSignUp() {
        return "sign-up";
    }

    @PostMapping("/try-sign-up")
    public String trySignUp(@RequestParam("mailAddress") String mailAddress,
                            @RequestParam("nickname") String nickname,
                            @RequestParam("password") String password,
                            Model model) {
        appUserService.addAppUser(mailAddress,nickname,password);
        return "home";
    }
}
