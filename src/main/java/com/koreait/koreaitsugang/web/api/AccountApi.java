package com.koreait.koreaitsugang.web.api;

import com.koreait.koreaitsugang.aop.annotation.ValidAspect;
import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.security.PrincipalDetails;
import com.koreait.koreaitsugang.service.AccountService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApi {

    @Autowired
    private AccountService accountService;

<<<<<<< HEAD
    @ValidAspect
    @PostMapping("/password")
    public ResponseEntity<? extends CMRespDto<? extends UserMst>> passencode(@RequestBody @Valid UserMst userMst, BindingResult bindingResult) {
=======
    @PutMapping("/encodePassword/{userId}")
    public ResponseEntity<? extends CMRespDto<?>> encodePassword(@PathVariable int userId, @RequestBody @Valid UserMst userMst, BindingResult bindingResult){
>>>>>>> parent of a4913de (지금까지 한거 올린거)

        UserMst user = accountService.registerUser(userMst);

        return ResponseEntity
                .created(URI.create("/api/account/user/" + userMst.getUserId()))
                .body(new CMRespDto<>(HttpStatus.CREATED.value(), "Create a new User", user));
    }


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

    @GetMapping("/principal")
    public ResponseEntity<CMRespDto<? extends PrincipalDetails>> getPrincpalDetails(@ApiParam(hidden = true) @AuthenticationPrincipal PrincipalDetails principalDetails) {

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
