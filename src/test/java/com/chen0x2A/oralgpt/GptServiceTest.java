package com.chen0x2A.oralgpt;

import com.chen0x2A.oralgpt.service.GptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GptServiceTest {

    @Autowired
    private GptService gptService;


    @Test
    public void testChat() {
        String testQuestion = "What is the weather today?";
        String response = gptService.chat(testQuestion, "testUser");

        assertNotNull(response, "The response from the chat method should not be null");
    }
}
