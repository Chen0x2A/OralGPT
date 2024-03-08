package com.chen0x2A.oralgpt.service;
import com.chen0x2A.oralgpt.mapper.ChatMapper;
import com.chen0x2A.oralgpt.model.Chat;
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

    public Chat getChatById(int id) {
        return chatMapper.getChatById(id);
    }
}
