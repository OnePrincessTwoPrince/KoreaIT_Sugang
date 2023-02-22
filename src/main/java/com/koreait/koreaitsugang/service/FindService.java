package com.koreait.koreaitsugang.service;

import com.koreait.koreaitsugang.repository.FindRepository;
import com.koreait.koreaitsugang.web.dto.FindReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindService {

    @Autowired
    private FindRepository findRepository;

    public int getSearchStudentId(FindReqDto findReqDto){
        return findRepository.getUserId(findReqDto);
    }

    public int getSearchStudentPassword(FindReqDto findReqDto){
        return findRepository.getStudentPassword(findReqDto);
    }
}
