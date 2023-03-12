package com.koreait.koreaitsugang.repository;

<<<<<<< HEAD
import com.koreait.koreaitsugang.entity.RoleDtl;
=======
import com.koreait.koreaitsugang.entity.MypageMst;
import com.koreait.koreaitsugang.entity.UserImage;
>>>>>>> ft-05
import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.web.dto.MypageMstReqDto;
import com.koreait.koreaitsugang.web.dto.UserImageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AccountRepository {
    public UserMst findUserByUserId(int userId);
    public UserMst findUserByUsername(String username);

    public int updatePassword(UserMst user);
<<<<<<< HEAD
    public int saveRole(RoleDtl roleDtl);
=======
    public int saveRole(UserMst user);

    public MypageMst findMypage(int userId);
    public int registerUserImages(List<UserImage> userImages);
>>>>>>> ft-05

    public List<UserImageDto> findUserImageAll(int userId);

    public UserImage findUserImageByImageId(int imageId);

    public UserImage findUserImageByUsername(int userId);

    public int deleteUserImage(int imageId);

    public void updateUserByUsername(MypageMstReqDto mypageMstReqDto);

    public MypageMst loadUserInformation(int userId);
}