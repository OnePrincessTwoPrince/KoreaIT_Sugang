package com.koreait.koreaitsugang.repository.admin;


import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
import com.koreait.koreaitsugang.web.dto.SearchReqDto;
import com.koreait.koreaitsugang.web.dto.SubjectReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectRepository {
    public List<String> majorCategory();

    public List<SubjectMst> searchSugang(SearchReqDto searchReqDto);
    public SubjectMst findBySubjectCode(int subjectCode);
    public int getSubjectTotalCount(SearchNumberListReqDto searchNumberListReqDto);

    public int deleteBySubjectCode(List<Integer> subjectCode);
    public int saveSubject(SubjectReqDto subjectReqDto);

    public int updateSubjectBySubjectCode(SubjectReqDto subjectReqDto);
}
