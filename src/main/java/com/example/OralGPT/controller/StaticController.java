package com.example.OralGPT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
    @GetMapping("/OralGPT/")
    public String index() {
        // 返回HTML页面
        return "GptChatRoom";
    }
}
