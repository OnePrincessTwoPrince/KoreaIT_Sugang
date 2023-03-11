package com.koreait.koreaitsugang.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminSearchController {

    @GetMapping("/usersearch")
    public String user_information(){
        return "admin/user_information";
    }

    @GetMapping("/userregister")
    public String user_register(){
        return "admin/user_register";
    }

    @GetMapping("/professorregister")
    public String professor_register() {
        return "admin/professor_register";
    }
}
