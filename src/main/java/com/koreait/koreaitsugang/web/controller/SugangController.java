package com.koreait.koreaitsugang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sugang")
public class SugangController {

    @GetMapping("/course")
    public String Sugang(){
        return "course";
    }
}
