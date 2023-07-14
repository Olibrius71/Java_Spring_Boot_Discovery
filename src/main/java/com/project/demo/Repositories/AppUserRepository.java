package com.project.demo.Repositories;

import com.project.demo.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    @Override
    Optional<AppUser> findById(Integer integer);

    AppUser findByNickname(String nickname);


    @Override
    List<AppUser> findAll();

    @Override
    <S extends AppUser> S save(S entity);

    @Override
    <S extends AppUser> List<S> saveAll(Iterable<S> entities);


    long count();


    @Override
    void deleteById(Integer integer);

    boolean existsByMailAddress(@NonNull String mailAddress);
    boolean existsByNickname(@NonNull String nickname);

    boolean existsByNicknameAndPassword(@NonNull String nickname, @NonNull String password);


    @Transactional
    @Modifying
    @Query("update AppUser u set u.mailAddress = ?1 where u.id = ?2")
    void updateMailAddressById(@NonNull String mailAddress, @NonNull int id);

    @Transactional
    @Modifying
    @Query("update AppUser u set u.nickname = ?1 where u.id = ?2")
    void updateNicknameById(@NonNull String nickname, @NonNull int id);

    @Transactional
    @Modifying
    @Query("update AppUser u set u.password = ?1 where u.id = ?2")
    void updatePasswordById(@NonNull String password, @NonNull int id);
}