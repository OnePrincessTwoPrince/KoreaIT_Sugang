package com.koreait.koreaitsugang.service;

import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

<<<<<<< HEAD
    public UserMst registerUser(UserMst userMst){
        userMst.setPassword(new BCryptPasswordEncoder().encode(userMst.getPassword()));

        accountRepository.saveUser(userMst);
        accountRepository.saveRole(userMst);

        return userMst;
=======
    public void updatePassword(UserMst userMst) {
        userMst.setPassword(new BCryptPasswordEncoder().encode(userMst.getPassword()));
        accountRepository.updatePassword(userMst);
        accountRepository.saveRole(userMst);
>>>>>>> parent of a4913de (지금까지 한거 올린거)
    }

    public void passwordEncoded(String password) {

    }

    public UserMst getUser(int userId){
        return accountRepository.findUserByUserId(userId);
    }

}