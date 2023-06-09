package com.project.demo.Services;

import com.project.demo.Entities.AppUser;
import com.project.demo.Repositories.AppUserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;


    public void addAppUser(String newMailAddress, String newNickname, String newPassword) throws ConstraintViolationException {
        try {
            AppUser newAppUser = new AppUser(newMailAddress, newNickname, newPassword);
            appUserRepository.save(newAppUser);
        }
        catch (ConstraintViolationException err) {
            throw new ConstraintViolationException((Set<? extends ConstraintViolation<?>>) err);
        }
    }

    public Boolean checkIfExistsAndPasswordCorrect(String possibleNickname, String possiblePassword) {
        return appUserRepository.existsByNicknameAndPassword(possibleNickname, possiblePassword);
    }

    public Boolean checkIfAlreadyExists(String newMailAddress, String newNickname) {
        return appUserRepository.existsByMailAddress(newMailAddress) || appUserRepository.existsByNickname(newNickname);
    }
}
