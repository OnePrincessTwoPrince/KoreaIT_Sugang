package com.koreait.koreaitsugang.web.api;

import com.koreait.koreaitsugang.service.SearchService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchApi {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<CMRespDto<?>> search(){
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",searchService.Categories()));
    }
}