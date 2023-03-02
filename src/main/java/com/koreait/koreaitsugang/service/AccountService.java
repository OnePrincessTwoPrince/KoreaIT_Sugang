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

    private final AccountRepository accountRepository;

    public void updatePassword(UserMst userMst) {
        userMst.setPassword(new BCryptPasswordEncoder().encode(userMst.getPassword()));
        accountRepository.updatePassword(userMst);
        accountRepository.saveRole(userMst);
    }

    public UserMst getUser(int userId){
        return accountRepository.findUserByUserId(userId);
    }


}

