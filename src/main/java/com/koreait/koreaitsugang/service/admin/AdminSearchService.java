package com.koreait.koreaitsugang.service.admin;

import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.exception.CustomValidationException;
import com.koreait.koreaitsugang.repository.admin.SubjectRepository;
import com.koreait.koreaitsugang.web.dto.DeleteSubjectsReqDto;
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
import com.koreait.koreaitsugang.web.dto.SearchReqDto;
import com.koreait.koreaitsugang.web.dto.SubjectReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminSearchService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<SubjectMst> searchSugang(SearchReqDto searchReqDto) {
        searchReqDto.setIndex();
        return subjectRepository.searchSugang(searchReqDto);
    }

    public List<String> Categories(){
        List<String> category = subjectRepository.majorCategory();
        return category;
    }

    public int getSubjectTotalCount(SearchNumberListReqDto searchNumberListReqDto) {
        return subjectRepository.getSubjectTotalCount(searchNumberListReqDto);
    }

    public void deleteSubject(DeleteSubjectsReqDto deleteSubjectsReqDto){
        subjectRepository.deleteBySubjectCode(deleteSubjectsReqDto.getSubjectCodes());
    }

    public void saveSubject(SubjectReqDto subjectReqDto){
        duplicateSubjectCode(subjectReqDto.getSubjectCode());
        subjectRepository.saveSubject(subjectReqDto);
    }

    public void modifySubject(SubjectReqDto subjectReqDto){
        subjectRepository.updateSubjectBySubjectCode(subjectReqDto);
    }

    public Map<String, Object> getSugang(int subjectCode){
        Map<String, Object> result = new HashMap<>();
        result.put("subjectMst", subjectRepository.findBySubjectCode(subjectCode));

        return result;
    }

    private void duplicateSubjectCode(int subjectCode) {
        SubjectMst subjectMst = subjectRepository.findBySubjectCode(subjectCode);
        if(subjectMst != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("subjectCode", "이미 존재하는 과목 코드입니다.");

            throw new CustomValidationException(errorMap);
        }
    }
}
