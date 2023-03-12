package com.koreait.koreaitsugang.repository;


import com.koreait.koreaitsugang.entity.SearchSubjectMst;
import com.koreait.koreaitsugang.web.dto.SearchSubjectReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SugangRepository {

    public List<String> searchCategory();
    public List<SearchSubjectMst> findSubjectCode(SearchSubjectReqDto searchSubjectReqDto);
}
