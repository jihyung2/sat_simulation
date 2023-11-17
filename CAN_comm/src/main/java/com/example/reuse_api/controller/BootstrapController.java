package com.example.reuse_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootstrapController {

    @RequestMapping("/index.html")
    public String Dashboard(){
        return "index";
    }
}

// 프론트와 관련한 추가적인 url 여기 작성
