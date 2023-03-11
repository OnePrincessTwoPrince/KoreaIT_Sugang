package com.koreait.koreaitsugang.web.api;


import com.koreait.koreaitsugang.entity.RoleDtl;
import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.security.PrincipalDetails;
import com.koreait.koreaitsugang.service.AccountService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @PutMapping("/encodePassword/{userId}")
    public ResponseEntity<? extends CMRespDto<?>> encodePassword(@RequestBody @Valid UserMst userMst){

        accountService.updatePassword(userMst);

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }

    @PostMapping("/saveRoleId")
    public ResponseEntity<?> saveRoleId(@RequestBody RoleDtl roleDtl) {
        accountService.saveRoleId(roleDtl);

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<? extends CMRespDto<? extends UserMst>> getUser(@PathVariable int userId){
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Success", accountService.getUser(userId)));
    }

    @GetMapping("/principal")
    public ResponseEntity<CMRespDto<? extends PrincipalDetails>> getPrincipalDetails(@AuthenticationPrincipal PrincipalDetails principalDetails) {

        if (principalDetails != null) {
            principalDetails.getAuthorities().forEach(role -> {
                log.info("로그인된 사용자의 권한 : {}", role.getAuthority());
            });
        }
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Success", principalDetails));
    }
}
