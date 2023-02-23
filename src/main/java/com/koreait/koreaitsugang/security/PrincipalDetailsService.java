<<<<<<< HEAD
=======

>>>>>>> 0f12c4d2b441e3f620b923b4e7ff5969b86e740b
package com.koreait.koreaitsugang.security;

import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
<<<<<<< HEAD
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserMst user = accountRepository.findUserByUsername(username);
=======
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        UserMst user = accountRepository.findUserByUsername(userId);
>>>>>>> 0f12c4d2b441e3f620b923b4e7ff5969b86e740b

        if (user == null) {
            throw new UsernameNotFoundException("회원정보를 확인할 수 없음");
        }

        return new PrincipalDetails(user);
    }
}
<<<<<<< HEAD
=======

>>>>>>> 0f12c4d2b441e3f620b923b4e7ff5969b86e740b
