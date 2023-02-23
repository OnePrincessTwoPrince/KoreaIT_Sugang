package com.koreait.koreaitsugang.repository;

import com.koreait.koreaitsugang.entity.UserMst;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {

    public UserMst findUserByUserId(String userId);
    public UserMst findUserByUsername(String userId);

    public int saveUser(UserMst user);
    public int saveRole(UserMst user);


}
