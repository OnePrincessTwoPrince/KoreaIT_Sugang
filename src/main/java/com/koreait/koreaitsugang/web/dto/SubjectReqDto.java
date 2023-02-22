package com.koreait.koreaitsugang.web.dto;

import lombok.Data;

@Data
public class SubjectReqDto {
    private String category;

    private int subjectCode;

    private String subjectName;

    private int credit;

    private String professorName;

    private String building;

    private String lectureTime;
}
