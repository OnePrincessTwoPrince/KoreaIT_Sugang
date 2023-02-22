package com.koreait.koreaitsugang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectMst {

    private int subjectCode;

    private int subjectYear;

    private int subjectSemester;

    private String collegeName;

    private String departmentName;

    private int subjectGrade;

    private String category;

    private String subjectName;

    private int subjectClass;

    private int credit;

    private String professorName;

    private String lectureTime;

    private String building;

    private int maxPerson;
}
