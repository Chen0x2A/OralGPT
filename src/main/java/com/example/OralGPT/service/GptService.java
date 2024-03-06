package com.example.OralGPT.service;

import com.theokanning.openai.completion.chat.ChatCompletionResult;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
@Service
public class GptService {


    private List<ChatMessage> conversationHistory = new ArrayList<>(); //ChatMessage组成的ArrayList

    //构造方法
    public GptService() {
    }

    public String chat(String question) {
        // 如果历史消息超过10条，仅保留最后10条
        if (conversationHistory.size() > 10) {
            conversationHistory = conversationHistory.subList(conversationHistory.size() - 10, conversationHistory.size());
        }

        // 添加新的用户消息到历史
        conversationHistory.add(new ChatMessage(ChatMessageRole.USER.value(), question));
        ChatCompletionResult result = createChatCompletion(conversationHistory);
        // 获取并添加模型的回应到历史
        String resp = result.getChoices().get(0).getMessage().getContent();
        conversationHistory.add(new ChatMessage(ChatMessageRole.ASSISTANT.value(), resp));
        System.out.println(question);
        System.out.println(resp);
        return resp;
    }

    public ChatCompletionResult createChatCompletion(List<ChatMessage> messages) {

        String apiToken = System.getenv("OPENAI_API_KEY");
        OpenAiService service = new OpenAiService(apiToken);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                // 模型名称
                .model("gpt-3.5-turbo")// 下面两项数值控制模型输出的随机性，对回答的稳定性要求高时，可设置随机性为最低
                .temperature(0.0D)
                .topP(1.0)
                .messages(messages)
                .build();
        return service.createChatCompletion(chatCompletionRequest);
    }

}

