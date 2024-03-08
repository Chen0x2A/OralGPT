package com.chen0x2A.oralgpt.controller;


import com.chen0x2A.oralgpt.model.Chat;
import com.chen0x2A.oralgpt.service.DbService;
import com.chen0x2A.oralgpt.service.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Object> getGptReply(@RequestParam("user_input") String userInput, @RequestParam("userid") String userid) {
        Map<String, Object> response = new HashMap<>();

        //得到gpt文本回复
        String gptReply = gptService.chat(userInput, userid);

        Map<String, String> content = new HashMap<>();
        content.put("text", gptReply);    //储存回复的文本
        response.put("content", content);
        Chat chat = new Chat(userid, userInput, gptReply);
        dbService.addChat(chat);
        return response;
    }
}


