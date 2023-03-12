package com.koreait.koreaitsugang.service;

<<<<<<< HEAD
import com.koreait.koreaitsugang.entity.SearchSubjectMst;
import com.koreait.koreaitsugang.repository.SugangRepository;
import com.koreait.koreaitsugang.web.dto.SearchSubjectReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugangService {

    @Autowired
    private SugangRepository sugangRepository;

    public List<SearchSubjectMst> findSubjectCode(SearchSubjectReqDto searchSubjectReqDto) {
        return sugangRepository.findSubjectCode(searchSubjectReqDto);
=======
import com.koreait.koreaitsugang.entity.ClassificationView;
import com.koreait.koreaitsugang.entity.OpenCourse;
import com.koreait.koreaitsugang.entity.PocketMst;
import com.koreait.koreaitsugang.exception.CustomApplyCountException;
import com.koreait.koreaitsugang.repository.SugangRepository;
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SugangService {

    private final SugangRepository sugangRepository;

    public List<ClassificationView> categories() {
        return sugangRepository.searchCategory();
    }

    public int getSearchTotalCourses(SearchNumberListReqDto searchNumberListReqDto) {
        return sugangRepository.searchTotalCourse(searchNumberListReqDto);
    }

    public List<OpenCourse> getOpenCourse(SearchSugangReqDto searchSugangReqDto) {
        searchSugangReqDto.setIndex();
        return sugangRepository.searchCourse(searchSugangReqDto);
    }

    public int applyCourse(int subjectCode, int userId){

        PocketMst pocketMst = PocketMst.builder()
                .subjectCode(subjectCode)
                .userId(userId)
                .build();

        return sugangRepository.saveCourse(pocketMst);
    }

    public int deleteCourse(int subjectCode, int userId) {
        PocketMst pocketMst = PocketMst.builder()
                .subjectCode(subjectCode)
                .userId(userId)
                .build();

        return sugangRepository.deleteCourse(pocketMst);
    }

    public OpenCourse loadCourses(PocketMst pocketMst) {
        return sugangRepository.loadCourse(pocketMst);
    }

    private void abilityApply(int subjectCode){

        int requestUser = sugangRepository.loadUserId(subjectCode);

        if (requestUser == 0) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("applyCountError", "이미 선택한 과목입니다.");

            throw new CustomApplyCountException(errorMap);
        }
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
    }
}
