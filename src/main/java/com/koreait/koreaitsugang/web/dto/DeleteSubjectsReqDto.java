package com.koreait.koreaitsugang.web.dto;

import lombok.Data;

import java.util.List;

@Data
<<<<<<< HEAD:src/main/java/com/koreait/koreaitsugang/web/dto/SearchSugangReqDto.java
public class SearchSugangReqDto {

    private int page;

    private String searchValue;

    private List<String> classification;

    private String limit;

    private int count;

    private int userId;

    private int index;

    public void setIndex() {
        index = (page-1)*count;
    }

=======
public class DeleteSubjectsReqDto {
    public List<Integer> subjectCodes;
>>>>>>> ft-05:src/main/java/com/koreait/koreaitsugang/web/dto/DeleteSubjectsReqDto.java
}
