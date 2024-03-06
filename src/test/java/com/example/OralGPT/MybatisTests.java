package com.example.OralGPT;

import com.example.OralGPT.mapper.ChatMapper;
import com.example.OralGPT.model.Chat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //springboot整合了单元测试的注解
class MybatisTests {


    @Autowired
    private ChatMapper chatMapper;

    @Test
    public void TestGetChatById() {
        int i=1;
        Chat chat = chatMapper.getChatById(i);
        System.out.println(chat);
    }
}

