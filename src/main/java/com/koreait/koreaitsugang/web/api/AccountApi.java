package com.koreait.koreaitsugang.web.api;

import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.security.PrincipalDetails;
import com.koreait.koreaitsugang.service.AccountService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @ApiResponses({
            @ApiResponse(code =400, message = "클라이언트가 잘못"),
            @ApiResponse(code =401, message = "클라이언트가 잘못2")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<? extends CMRespDto<? extends UserMst>> getUser(@PathVariable int userId){
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Success", accountService.getUser(userId)));
    }

//    @GetMapping("/principal")
//    public ResponseEntity<CMRespDto<? extends PrincipalDetails>> getPrincpalDetails(@ApiParam(hidden = true) @AuthenticationPrincipal PrincipalDetails principalDetails) {
//
//        if (principalDetails != null) {
//            principalDetails.getAuthorities().forEach(role -> {
//                log.info("로그인된 사용자의 권한 : {}", role.getAuthority());
//            });
//        }
//        return ResponseEntity
//                .ok()
//                .body(new CMRespDto<>(HttpStatus.OK.value(), "Success", principalDetails));
//    }
}
