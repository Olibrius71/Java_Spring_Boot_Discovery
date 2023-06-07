package com.project.demo.Services;

import com.project.demo.Entities.AppUser;
import com.project.demo.Repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;


    public void addAppUser(String newMailAddress, String newNickname, String newPassword) {
        AppUser newAppUser = new AppUser(newMailAddress, newNickname, newPassword);
        appUserRepository.save(newAppUser);
    }

    public Boolean checkIfExistsAndPasswordCorrect(String possibleNickname, String possiblePassword) {
        return appUserRepository.existsByNicknameAndPassword(possibleNickname, possiblePassword);
    }
}
