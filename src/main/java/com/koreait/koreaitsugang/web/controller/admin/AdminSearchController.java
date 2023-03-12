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
    
}
