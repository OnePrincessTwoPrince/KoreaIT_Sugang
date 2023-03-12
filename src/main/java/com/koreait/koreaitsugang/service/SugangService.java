package com.koreait.koreaitsugang.service;

import com.koreait.koreaitsugang.entity.SearchSubjectMst;
import com.koreait.koreaitsugang.repository.SugangRepository;
import com.koreait.koreaitsugang.web.dto.SearchSubjectReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugangService {

    @Autowired
    private SugangRepository sugangRepository;

    public List<SearchSubjectMst> findSubjectCode(SearchSubjectReqDto searchSubjectReqDto) {
        return sugangRepository.findSubjectCode(searchSubjectReqDto);
    }
}
