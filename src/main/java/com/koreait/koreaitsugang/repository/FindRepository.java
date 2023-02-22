package com.koreait.koreaitsugang.repository;

import com.koreait.koreaitsugang.web.dto.FindReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FindRepository {
    public int getUserId(FindReqDto findReqDto);
    public int getStudentPassword(FindReqDto findReqDto);
}
