package com.koreait.koreaitsugang.web.dto;

import com.koreait.koreaitsugang.entity.SearchSubjectMst;
import lombok.Data;

import java.util.List;

@Data
public class DeleteSubjectsReqDto {
    public List<Integer> subjectCodes;

}
