package com.koreait.koreaitsugang.web.api;

<<<<<<< HEAD
=======
import com.koreait.koreaitsugang.aop.annotation.ParamsAspect;
import com.koreait.koreaitsugang.aop.annotation.ValidAspect;
import com.koreait.koreaitsugang.entity.ClassificationView;
import com.koreait.koreaitsugang.security.PrincipalDetails;
import com.koreait.koreaitsugang.security.PrincipalDetailsService;
>>>>>>> parent of a4913de (지금까지 한거 올린거)
import com.koreait.koreaitsugang.service.SearchService;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
<<<<<<< HEAD
=======
import lombok.RequiredArgsConstructor;
>>>>>>> parent of a4913de (지금까지 한거 올린거)
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
<<<<<<< HEAD
                .body(new CMRespDto<>(HttpStatus.OK.value(),"Successfully",searchService.Categories()));
=======
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

        if (principalDetails != null) {
            searchSugangReqDto.setUserId(principalDetails.getUser().getUserId());
        }

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", searchService.getOpenCourse(searchSugangReqDto)));
    }

    @ParamsAspect
    @PostMapping("/apply/{subjectCode}")
    public ResponseEntity<CMRespDto<?>> applyCourse(@PathVariable int subjectCode, @AuthenticationPrincipal PrincipalDetails principalDetails){
        searchService.applyCourse(principalDetails.getUser().getUserId(), subjectCode);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
>>>>>>> parent of a4913de (지금까지 한거 올린거)
    }
}