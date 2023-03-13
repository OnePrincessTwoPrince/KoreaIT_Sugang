package com.koreait.koreaitsugang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pocket")
public class SugangApplyController {

    @GetMapping("")
    public String loadSugang(){
        return "pocket";
    }
}
