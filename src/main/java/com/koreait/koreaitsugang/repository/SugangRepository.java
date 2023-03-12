package com.koreait.koreaitsugang.repository;

<<<<<<< HEAD
import com.koreait.koreaitsugang.entity.ClassificationView;
import com.koreait.koreaitsugang.entity.OpenCourse;
import com.koreait.koreaitsugang.entity.PocketMst;
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
=======

>>>>>>> ft-05
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SugangRepository {

    public List<ClassificationView> searchCategory();

    public int searchTotalCourse(SearchNumberListReqDto searchNumberListReqDto);

    public List<OpenCourse> searchCourse(SearchSugangReqDto searchSugangReqDto);


    public int loadUserId(int userId);

    public int availabilityApply(int subjectCode);

    public int saveCourse(PocketMst pocketMst);

    public int deleteCourse(PocketMst pocketMst);

    public OpenCourse loadCourse(PocketMst pocketMst);

}
