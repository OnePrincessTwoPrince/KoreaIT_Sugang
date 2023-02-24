package com.koreait.koreaitsugang.repository.admin;

import com.koreait.koreaitsugang.web.dto.admin.AdminSearchReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorRepository {
    public List<String> majorCategory();

}
