package com.project.demo.Controllers;


import com.project.demo.Services.AppUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolationException;
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
                            Model model,
                            HttpSession httpSession) {
        try {
            appUserService.addAppUser(mailAddress,nickname,password);
            httpSession.setAttribute("loggedIn",true);
            httpSession.setAttribute("userNickname",nickname);
            return "redirect:/";
        }
        catch (ConstraintViolationException err) {
            model.addAttribute("attributesConstraintNotRespected","Contraintes non respectées");
            return "sign-up";
        }

    }
}
