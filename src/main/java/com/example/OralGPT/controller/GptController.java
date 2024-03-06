package com.example.OralGPT.controller;


import com.example.OralGPT.model.Chat;
import com.example.OralGPT.service.DbService;
import com.example.OralGPT.service.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


@RestController
public class GptController {

    @Autowired
    private GptService gptService;

    @Autowired
    private DbService dbService;


    @PostMapping("/get_gpt_reply") //接收前端的文本数据，返回包含文本和音频数据的哈希表
    //在@Restcontroller注解下，Spring会自动把哈希表转换为json格式，这样前端接收到的就是json格式的内容
    public Map<String, Object> getGptReply(@RequestParam("user_input") String userInput) {
        Map<String, Object> response = new HashMap<>();

        //得到gpt文本回复
        String gptReply = gptService.chat(userInput);
        //创建哈希表储存回复
        Map<String, String> content = new HashMap<>();
        content.put("text", gptReply);
        response.put("content", content);
        //储存本次对话到mysql数据库中
        String userid="czb";
        Chat chat=new Chat(userid,userInput,gptReply);
        dbService.addChat(chat);
        return response;
    }
}