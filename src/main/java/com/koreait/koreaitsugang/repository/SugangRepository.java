package com.koreait.koreaitsugang.repository;

import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SugangRepository {

    public List<String> searchCategory(SearchSugangReqDto searchSugangReqDto);

}
