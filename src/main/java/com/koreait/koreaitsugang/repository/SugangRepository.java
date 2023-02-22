package com.koreait.koreaitsugang.repository;

import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SugangRepository {

    public SubjectMst searchCategory(SearchSugangReqDto searchSugangReqDto);

}
