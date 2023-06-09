package com.project.demo.Controllers;


import com.project.demo.Services.AppUserService;
import jakarta.persistence.UniqueConstraint;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Set;
import java.util.regex.Pattern;

@Controller
public class SignUpController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/sign-up")
    public String viewSignUp() {
        return "sign-up";
    }


    private Boolean areParametersValid(String mailAddress, String nickname, String password) {
        if (nickname.length() < 6)
            return false;

        Pattern isPasswordValid = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$");
        if (password.length() < 10 || !isPasswordValid.matcher(password).matches()) {
            return false;
        }

        Pattern isEmailRegex = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-z]+$");
        return isEmailRegex.matcher(mailAddress).matches();
    }
    @PostMapping("/try-sign-up")
    public String trySignUp(@RequestParam("mailAddress") String mailAddress,
                            @RequestParam("nickname") String nickname,
                            @RequestParam("password") String password,
                            Model model,
                            HttpSession httpSession) throws ConstraintViolationException {

        if (appUserService.checkIfAlreadyExists(mailAddress,nickname)) {
            model.addAttribute("attributeConstraintNotRespected","Cette addresse mail ou nom d'utilisateur est déjà utilisé(e)");
            return "sign-up";
        }
        else if (areParametersValid(mailAddress, nickname, password)) {
            appUserService.addAppUser(mailAddress, nickname, password);
            httpSession.setAttribute("loggedIn", true);
            httpSession.setAttribute("userNickname", nickname);
            return "redirect:/";
        }

        else {
            model.addAttribute("attributeConstraintNotRespected","L'adresse mail doit être correcte, le nom d'utilisateur de au moins 6 lettres et le mot de passe doit contenir au moins 10 charactères dont des lettres MAJUSCULES, minuscules et des chiffres");
            return "sign-up";
        }

    }

}
