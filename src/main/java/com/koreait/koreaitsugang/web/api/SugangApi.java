package com.koreait.koreaitsugang.web.api;

import com.koreait.koreaitsugang.aop.annotation.ParamsAspect;
<<<<<<< HEAD
import com.koreait.koreaitsugang.aop.annotation.ValidAspect;
import com.koreait.koreaitsugang.entity.SearchSubjectMst;
import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.service.SugangService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import com.koreait.koreaitsugang.web.dto.SearchReqDto;
import com.koreait.koreaitsugang.web.dto.SearchSubjectReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sugang")
public class SugangApi {
    @Autowired
    private SugangService sugangService;


    @GetMapping("/search")
    public ResponseEntity<CMRespDto<List<SearchSubjectMst>>> searchSugang(@Valid SearchSubjectReqDto searchSubjectReqDto, BindingResult bindingResult){
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully", sugangService.findSubjectCode(searchSubjectReqDto)));
    }
}
=======
import com.koreait.koreaitsugang.entity.ClassificationView;
import com.koreait.koreaitsugang.entity.PocketMst;
import com.koreait.koreaitsugang.security.PrincipalDetails;
import com.koreait.koreaitsugang.service.SugangService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SugangApi {

    private final SugangService searchService;

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

        if (principalDetails == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new CMRespDto<>(HttpStatus.BAD_REQUEST.value(), "Failed", null));
        }

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", searchService.getOpenCourse(searchSugangReqDto)));
    }

    @ParamsAspect
    @PostMapping("/apply")
    public ResponseEntity<CMRespDto<?>> applyCourse(@RequestBody PocketMst pocketMst, @AuthenticationPrincipal PrincipalDetails principalDetails){
        searchService.applyCourse(pocketMst.getSubjectCode(), principalDetails.getUser().getUserId());
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", pocketMst));
    }

    @ParamsAspect
    @DeleteMapping("/delete")
    public ResponseEntity<CMRespDto<?>> deleteCourse(@RequestBody PocketMst pocketMst, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        searchService.deleteCourse(pocketMst.getSubjectCode(), principalDetails.getUser().getUserId());

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", pocketMst));
    }

    @GetMapping("/load")
    public ResponseEntity<CMRespDto<?>> loadCourses(@RequestBody PocketMst pocketMst) {
        searchService.loadCourses(pocketMst);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", searchService.loadCourses(pocketMst)));
    }
}
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
