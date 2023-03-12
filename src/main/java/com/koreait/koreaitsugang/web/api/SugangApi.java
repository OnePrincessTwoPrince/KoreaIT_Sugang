package com.koreait.koreaitsugang.web.api;

import com.koreait.koreaitsugang.aop.annotation.ParamsAspect;
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
