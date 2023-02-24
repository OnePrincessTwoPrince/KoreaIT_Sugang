package com.koreait.koreaitsugang.web.dto.admin;

import lombok.Data;

import java.util.List;

@Data
public class SearchUserReqDto {
    private int page;

    private String searchValue;

    private List<String> major;

    private int count;

    private int userId;


    private int index;

    public void setIndex() {
        index = (page - 1) * count;
    }
}
