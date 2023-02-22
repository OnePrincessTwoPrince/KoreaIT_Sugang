package com.koreait.koreaitsugang.web.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class FastSugangReqDto {

    @NotBlank
    private int subjectCode;

    @NotBlank
    private int subjectClass;

    private int studentId;

    private String professorName;

    private LocalDateTime insertTime;

    private int grade;
}
