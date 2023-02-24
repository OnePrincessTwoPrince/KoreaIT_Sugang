package com.koreait.koreaitsugang.web.dto.admin;

import lombok.Data;

import java.util.List;

@Data
public class AdminSearchReqDto {

    private String searchValue;

    private String major;

    private int page;

    private int count;

    private int index;

    public void setIndex(){
        index = (page - 1) * count;
    }

}
