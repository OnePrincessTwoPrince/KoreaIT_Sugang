package com.koreait.koreaitsugang.web.api.admin;

import com.koreait.koreaitsugang.service.admin.AdminSearchService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import com.koreait.koreaitsugang.web.dto.admin.AdminSearchReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminSearchApi {

    @Autowired
    private AdminSearchService adminSearchService;

    @GetMapping("/admin")
    public ResponseEntity<CMRespDto<?>> search(){
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",adminSearchService.Categories()));
    }

}
