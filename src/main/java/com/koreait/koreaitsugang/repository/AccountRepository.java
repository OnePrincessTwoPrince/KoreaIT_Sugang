package com.koreait.koreaitsugang.repository;

import com.koreait.koreaitsugang.entity.RoleDtl;
import com.koreait.koreaitsugang.entity.UserMst;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public UserMst findUserByUserId(int userId);
    public UserMst findUserByUsername(String username);

    public int updatePassword(UserMst user);
    public int saveRole(RoleDtl roleDtl);

}
