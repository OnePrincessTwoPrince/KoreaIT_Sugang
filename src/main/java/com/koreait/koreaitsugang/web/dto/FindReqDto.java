package com.koreait.koreaitsugang.web.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class FindReqDto {

    private String username;

    private String birthDate;

    private int userId;

    @Email
    private String email;

    private int password;
}
