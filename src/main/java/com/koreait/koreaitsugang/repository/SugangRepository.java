package com.koreait.koreaitsugang.repository;

import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SugangRepository {

<<<<<<< HEAD
    public List<String> searchCategory();
=======
    public List<ClassificationView> searchCategory();

    public int searchTotalCourse(SearchNumberListReqDto searchNumberListReqDto);

    public List<OpenCourse> searchCourse(SearchSugangReqDto searchSugangReqDto);

    public int availabilityApply(int subjectCode);

    public int saveCourse(PocketMst pocketMst);

>>>>>>> parent of a4913de (지금까지 한거 올린거)

}
