package com.koreait.koreaitsugang.web.api;

import com.koreait.koreaitsugang.aop.annotation.ParamsAspect;
import com.koreait.koreaitsugang.aop.annotation.ValidAspect;
import com.koreait.koreaitsugang.entity.ClassificationView;
import com.koreait.koreaitsugang.security.PrincipalDetails;
import com.koreait.koreaitsugang.security.PrincipalDetailsService;
import com.koreait.koreaitsugang.service.SearchService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchApi {

    private final SearchService searchService;

    @GetMapping("/classification")
    public ResponseEntity<CMRespDto<List<ClassificationView>>> search(){

        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",searchService.categories()));
    }

    @GetMapping("/search/total")
    public ResponseEntity<CMRespDto<Integer>> totalCount(SearchNumberListReqDto searchNumberListReqDto) {
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", searchService.getSearchTotalCourses(searchNumberListReqDto)));
    }

    @ParamsAspect
    @GetMapping("/open")
    public ResponseEntity<CMRespDto<?>> openCourses(SearchSugangReqDto searchSugangReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){

        if (principalDetails != null) {
            searchSugangReqDto.setUserId(principalDetails.getUser().getUserId());
        }

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", searchService.getOpenCourse(searchSugangReqDto)));
    }

    @ParamsAspect
    @PostMapping("/apply/{subjectCode}")
    public ResponseEntity<CMRespDto<?>> applyCourse(@PathVariable int subjectCode, @AuthenticationPrincipal PrincipalDetails principalDetails){
        searchService.applyCourse(principalDetails.getUser().getUserId(), subjectCode);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }
}