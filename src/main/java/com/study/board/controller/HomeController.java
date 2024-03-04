package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { //사이트의 메인화면
    // 기본 페이지 요청 메서드
    @GetMapping("/")
    public String index(){
        return "index";  //기본 요청이 들어왔을때 index.html 화면을 띄울거라는 뜻 > templates 폴더의 index.html을 찾아감
    }
}
