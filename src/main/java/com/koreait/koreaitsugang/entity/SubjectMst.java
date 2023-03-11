package com.koreait.koreaitsugang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectMst {
    private int subjectCode;
}