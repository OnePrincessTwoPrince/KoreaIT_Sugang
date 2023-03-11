package com.koreait.koreaitsugang.service;

import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.repository.SugangRepository;
<<<<<<< HEAD
=======
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
>>>>>>> parent of a4913de (지금까지 한거 올린거)
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SugangRepository sugangRepository;

    public List<String> Categories() {
        return sugangRepository.searchCategory();
    }
<<<<<<< HEAD
=======

    public int getSearchTotalCourses(SearchNumberListReqDto searchNumberListReqDto) {
        return sugangRepository.searchTotalCourse(searchNumberListReqDto);
    }

    public List<OpenCourse> getOpenCourse(SearchSugangReqDto searchSugangReqDto) {
        searchSugangReqDto.setIndex();
        return sugangRepository.searchCourse(searchSugangReqDto);
    }

    public void applyCourse(int subjectCode, int userId){
        abilityApply(subjectCode);

        PocketMst pocketMst = PocketMst.builder()
                .subjectCode(subjectCode)
                .userId(userId)
                .build();

        sugangRepository.saveCourse(pocketMst);
    }

    private void abilityApply(int subjectCode){
        int applyCount = sugangRepository.availabilityApply(subjectCode);
        if (applyCount > 0) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("applyCountError", "이미 선택한 과목입니다.");

            throw new CustomApplyCountException(errorMap);
        }
    }
>>>>>>> parent of a4913de (지금까지 한거 올린거)
}
