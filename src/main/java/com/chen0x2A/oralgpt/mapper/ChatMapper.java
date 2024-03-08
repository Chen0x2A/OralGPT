package com.chen0x2A.oralgpt.mapper;

import com.chen0x2A.oralgpt.model.Chat;
import org.apache.ibatis.annotations.Mapper;

@Mapper //程序运行时，自动生成该接口的实现类对象（Bean),不需要我们自己构造（也因此不必写构造方法）,并将该对象交给IOC容器管理
public interface ChatMapper {

    //定义getChatById方法
    Chat getChatById(int id);

    //定义insert方法
    int insertChat(Chat chat);

}
