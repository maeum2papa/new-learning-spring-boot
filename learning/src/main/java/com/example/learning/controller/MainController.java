package com.example.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("name", "Papa");
        return "hello"; //templates 안에 hello.mustacche 를 자동으로 불러온다.
    }

}
