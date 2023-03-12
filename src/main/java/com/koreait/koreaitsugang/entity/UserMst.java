package com.koreait.koreaitsugang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======

>>>>>>> ft-05
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserMst {
    private int userId;

<<<<<<< HEAD
    private String category;

=======
>>>>>>> ft-05
    private String username;

    private String password;

    private String name;

    private String phone;

    private String birthDate;

    private String email;

    private String address;

    private String departmentNumber;

    private int grade;

    private List<RoleDtl> roleDtl;
<<<<<<< HEAD

    private int roleId;


}
=======
}
>>>>>>> ft-05
