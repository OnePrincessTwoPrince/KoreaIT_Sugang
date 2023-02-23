package com.koreait.koreaitsugang.service;

import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public UserMst registerUser(UserMst userMst){
        userMst.setPassword(new BCryptPasswordEncoder().encode(userMst.getPassword()));

        accountRepository.saveUser(userMst);
        accountRepository.saveRole(userMst);

        return userMst;
    }

    public void passwordEncoded(String password) {

    }

    public UserMst getUser(int userId){
        return accountRepository.findUserByUserId(userId);
    }

}
