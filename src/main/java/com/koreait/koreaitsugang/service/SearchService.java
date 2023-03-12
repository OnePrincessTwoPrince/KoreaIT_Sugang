package com.koreait.koreaitsugang.service;

import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.repository.SugangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SugangRepository sugangRepository;

    public List<String> Categories() {
        return sugangRepository.searchCategory();
    }
}
