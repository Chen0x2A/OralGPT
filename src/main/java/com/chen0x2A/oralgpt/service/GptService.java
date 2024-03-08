package com.chen0x2A.oralgpt.service;

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
import java.util.*;

@Service
public class GptService {


    private Map<String, List<ChatMessage>> userConversations = new HashMap<>();

    //构造方法
    public GptService() {
    }

    public String chat(String question, String userid) {
        List<ChatMessage> conversationHistory = userConversations.getOrDefault(userid, new ArrayList<>());

        if (conversationHistory.size() > 5) {
            conversationHistory = conversationHistory.subList(conversationHistory.size() - 5, conversationHistory.size());
        }

        conversationHistory.add(new ChatMessage(ChatMessageRole.USER.value(), question));
        ChatCompletionResult result = createChatCompletion(conversationHistory);
        String resp = result.getChoices().get(0).getMessage().getContent();
        conversationHistory.add(new ChatMessage(ChatMessageRole.ASSISTANT.value(), resp));

        System.out.println(question);
        System.out.println(resp);
        userConversations.put(userid, conversationHistory);

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

