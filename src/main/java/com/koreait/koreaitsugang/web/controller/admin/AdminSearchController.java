package com.koreait.koreaitsugang.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminSearchController {

    @GetMapping("")
    public String user_information(){
        return "admin/user_information";
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba

//    @GetMapping("/search")
//    public String sugang_information(){
//        return "admin/sugang_information";
//    }
//
//    @GetMapping("/sugang")
//    public String sugang_register(){
//        return "admin/sugang_register";
//    }
//
//    @GetMapping("/sugang/{subjectCode}")
//    public String sugang_modify(@PathVariable int subjectCode) {
//        return "admin/sugang_modification";
//  }
<<<<<<< HEAD
=======
=======
    
>>>>>>> 5cb488122923b1964c8ac614d132c8e792c6cb7a
>>>>>>> 66c67103ef1518def3131ce908c3d0f299a5acba
}
