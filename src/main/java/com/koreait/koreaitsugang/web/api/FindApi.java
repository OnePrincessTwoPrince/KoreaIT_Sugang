package com.koreait.koreaitsugang.web.api;

import com.koreait.koreaitsugang.service.FindService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import com.koreait.koreaitsugang.web.dto.FindReqDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/api/user")
public class FindApi {

    @Autowired
    private FindService findService;

    @PostMapping("/find/{userId}")
    public ResponseEntity<CMRespDto<?>> findid(FindReqDto findReqDto){
        findService.getSearchStudentId(findReqDto);

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully",findReqDto.getUserId()));
    }

    public ResponseEntity<CMRespDto<?>> findpassword(FindReqDto findReqDto){
        findService.getSearchStudentPassword(findReqDto);

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully",findReqDto.getPassword()));
    }
}
