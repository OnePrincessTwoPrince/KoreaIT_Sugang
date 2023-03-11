package com.koreait.koreaitsugang.web.api.admin;

import com.koreait.koreaitsugang.aop.annotation.ParamsAspect;
import com.koreait.koreaitsugang.aop.annotation.ValidAspect;
import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.service.admin.AdminSearchService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import com.koreait.koreaitsugang.web.dto.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AdminSearchApi {

    @Autowired
    private AdminSearchService adminSearchService;

    @GetMapping("/admin/usersearch")
    public ResponseEntity<CMRespDto<?>> search(){
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",adminSearchService.Categories()));
    }

    @GetMapping("/admin/userregister")
    public ResponseEntity<CMRespDto<?>> register(){
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",adminSearchService.Categories()));
    }

    @GetMapping("/admin/totalcount")
    public ResponseEntity<CMRespDto<?>> getUserTotalCount(AdminSearchReqDto adminSearchReqDto){
        return ResponseEntity.ok().body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully",adminSearchService.UserTotalCounts(adminSearchReqDto)));
    }

    @ParamsAspect
    @ValidAspect
    @GetMapping("/admin/users")
    public ResponseEntity<CMRespDto<List<UserMst>>> searchUser(@Valid AdminSearchReqDto adminSearchReqDto, BindingResult bindingResult){
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully",adminSearchService.getAdminSearchUser(adminSearchReqDto)));
    }
    @ParamsAspect
    @DeleteMapping("/admin/{username}")
    public ResponseEntity<CMRespDto<?>> removeUser(@PathVariable String username){
        adminSearchService.removeUser(username);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully",true));
    }

    @ParamsAspect
    @DeleteMapping("/admin/users")
    public ResponseEntity<CMRespDto<?>> removeUsers(@RequestBody DeleteUserReqDto deleteUserReqDto){
        adminSearchService.removeUsers(deleteUserReqDto);
        return ResponseEntity.ok().body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully",true));
    }

    @ParamsAspect
    @PostMapping("/admin/user/{username}/images")
    public ResponseEntity<CMRespDto<?>> registerUserImg(@PathVariable String username, @RequestPart List<MultipartFile> files) {
        adminSearchService.registerUserImage(username, files);
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }

    @ParamsAspect
    @PostMapping("/admin/user/{username}/images/modification")
    public ResponseEntity<CMRespDto<?>> modifyUserImg(@PathVariable String username, @RequestPart List<MultipartFile> files) {
        adminSearchService.registerUserImage(username, files);
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }


    @ParamsAspect
    @ValidAspect
    @PostMapping("/admin/studentRegister")
    public ResponseEntity<CMRespDto<?>> registerStudent(@Valid @RequestBody AddStudentReqDto addStudentReqDto, BindingResult bindingResult){
        adminSearchService.registerStudent(addStudentReqDto);
        return ResponseEntity.created(null).body(new CMRespDto<>(HttpStatus.CREATED.value(), "Successfully", true));
    }

    @ParamsAspect
    @ValidAspect
    @PostMapping("/admin/professorRegister")
    public ResponseEntity<CMRespDto<?>> registerProfessor(@Valid @RequestBody AddProfessorReqDto addProfessorReqDto, BindingResult bindingResult){
        adminSearchService.registerProfessor(addProfessorReqDto);
        return ResponseEntity.created(null).body(new CMRespDto<>(HttpStatus.CREATED.value(), "Successfully", true));
    }

    @GetMapping("/admin/user/{username}")
    public ResponseEntity<CMRespDto<Map<String, Object>>> getUser(@PathVariable String username){
        return ResponseEntity.ok().body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",adminSearchService.getUsernameAndImage(username)));
    }

    @ParamsAspect
    @ValidAspect
    @PutMapping("/admin/user/{username}")
    public ResponseEntity<CMRespDto<?>> updateStudent(@Valid @RequestBody UpdateStudentReqDto updateStudentReqDto, BindingResult bindingResult){
        adminSearchService.modifyStudent(updateStudentReqDto);
        return ResponseEntity.ok().body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully",true));
    }


    @DeleteMapping("/admin/user/{username}/image/{imageId}")
    public ResponseEntity<CMRespDto<?>> removeUserImage(@PathVariable String username, @PathVariable int imageId){
        adminSearchService.removeUserImage(username);

        return ResponseEntity.ok().body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", null));
    }
}

