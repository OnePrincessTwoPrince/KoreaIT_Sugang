package com.koreait.koreaitsugang.web.api.admin;

import com.koreait.koreaitsugang.aop.annotation.ParamsAspect;
import com.koreait.koreaitsugang.aop.annotation.ValidAspect;
import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.service.admin.AdminSearchService;
import com.koreait.koreaitsugang.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminSearchApi {

    @Autowired
    private AdminSearchService adminSearchService;

    @GetMapping("")
    public ResponseEntity<CMRespDto<?>> search(){
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",adminSearchService.Categories()));
    }

    @GetMapping("/sugang/{subjectCode}")
    public ResponseEntity<CMRespDto<Map<String, Object>>> getSugang(@PathVariable("subjectCode") int subjectCode) {
<<<<<<< HEAD
        return ResponseEntity
                .ok()
=======
        return ResponseEntity.ok()
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",adminSearchService.getSugang(subjectCode)));
    }

    @ParamsAspect
    @ValidAspect
    @GetMapping("/search")
    public ResponseEntity<CMRespDto<List<SubjectMst>>> searchSugang(@Valid SearchReqDto searchReqDto, BindingResult bindingResult){
<<<<<<< HEAD
        return ResponseEntity
                .ok()
=======
        return ResponseEntity.ok()
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully", adminSearchService.searchSugang(searchReqDto)));
    }

    @GetMapping("/sugangs/totalcount")
    public ResponseEntity<CMRespDto<?>> getSubjectTotalCount(SearchNumberListReqDto searchNumberListReqDto){
<<<<<<< HEAD
        return ResponseEntity
                .ok()
=======
        return ResponseEntity.ok()
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully", adminSearchService.getSubjectTotalCount(searchNumberListReqDto)));
    }

    @ParamsAspect
    @DeleteMapping("/sugangs")
    public ResponseEntity<CMRespDto<?>> deleteSubject(@RequestBody DeleteSubjectsReqDto deleteSubjectsReqDto){
        adminSearchService.deleteSubject(deleteSubjectsReqDto);
<<<<<<< HEAD
        return ResponseEntity
                .ok()
=======
        return ResponseEntity.ok()
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully", true));
    }

    @ParamsAspect
    @ValidAspect
    @PostMapping("/sugang")
    public ResponseEntity<CMRespDto<?>> saveSubject(@RequestBody @Valid SubjectReqDto subjectReqDto, BindingResult bindingResult){
        adminSearchService.saveSubject(subjectReqDto);
        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>(HttpStatus.CREATED.value(), "Successfully",true));
    }

    @ParamsAspect
    @ValidAspect
    @PatchMapping("/sugang/{subjectCode}")
    public ResponseEntity<CMRespDto<?>> modifySubject(@PathVariable("subjectCode") int subjectCode, @Valid @RequestBody SubjectReqDto subjectReqDto, BindingResult bindingResult){
        adminSearchService.modifySubject(subjectReqDto);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }
}
