package com.koreait.koreaitsugang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserImage {
=======
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserImage {
    private int userId;
>>>>>>> ft-05
    private int imageId;
    private String username;
    private String saveName;
    private String originName;
<<<<<<< HEAD
}
=======
}
>>>>>>> ft-05
