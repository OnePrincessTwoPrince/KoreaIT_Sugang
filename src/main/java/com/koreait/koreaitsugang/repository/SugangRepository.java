package com.koreait.koreaitsugang.repository;


<<<<<<< HEAD
import com.koreait.koreaitsugang.entity.SearchSubjectMst;
import com.koreait.koreaitsugang.web.dto.SearchSubjectReqDto;
=======
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SugangRepository {

    public List<String> searchCategory();
    public List<SearchSubjectMst> findSubjectCode(SearchSubjectReqDto searchSubjectReqDto);
}
