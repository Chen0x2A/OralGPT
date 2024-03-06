package com.example.OralGPT.service;
import com.example.OralGPT.model.Chat;
import com.example.OralGPT.mapper.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//ChatService类，在service层，不是主程序,但也同样重要，为应用提供基础服务（比如这个类提供数据库CRUD服务）
@Service
public class DbService {

    @Autowired //自动构造一个Bean并注入到ChatService类中（ChatMapper实例），因此ChatMapper类不需要构造方法
    private ChatMapper chatMapper;

    public void addChat(Chat chat) {
        chatMapper.insertChat(chat);
    }

    public void getChatById(int id) {
        chatMapper.getChatById(id);
    }
}
