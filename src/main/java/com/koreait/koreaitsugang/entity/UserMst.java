package com.koreait.koreaitsugang.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserMst {
    private int userId;

    private String category;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String birthDate;

    @Email
    private String email;

    private String address;

    private String departmentNumber;

    private int grade;

    private List<RoleDtl> roleDtl;


}
