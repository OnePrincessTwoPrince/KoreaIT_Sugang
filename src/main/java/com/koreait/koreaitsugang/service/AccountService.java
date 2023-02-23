package com.koreait.koreaitsugang.service;

import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.security.crypto.bcrypt.BCrypt;
>>>>>>> 0f12c4d2b441e3f620b923b4e7ff5969b86e740b
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

<<<<<<< HEAD
=======
    public void passwordEncoded(String password) {

    }

>>>>>>> 0f12c4d2b441e3f620b923b4e7ff5969b86e740b
    public UserMst getUser(int userId){
        return accountRepository.findUserByUserId(userId);
    }

<<<<<<< HEAD

=======
>>>>>>> 0f12c4d2b441e3f620b923b4e7ff5969b86e740b
}
