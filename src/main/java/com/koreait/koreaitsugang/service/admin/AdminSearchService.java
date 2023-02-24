package com.koreait.koreaitsugang.service.admin;

import com.koreait.koreaitsugang.repository.admin.MajorRepository;
import com.koreait.koreaitsugang.web.dto.SearchSugangReqDto;
import com.koreait.koreaitsugang.web.dto.admin.AdminSearchReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSearchService {

    @Autowired
    private MajorRepository majorRepository;

    public List<String> Categories(){
        List<String> category = majorRepository.majorCategory();
        System.out.println(category);
        return category;
    }
}
