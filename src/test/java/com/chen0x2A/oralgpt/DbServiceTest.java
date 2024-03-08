package com.chen0x2A.oralgpt;

import com.chen0x2A.oralgpt.mapper.ChatMapper;
import com.chen0x2A.oralgpt.model.Chat;
import com.chen0x2A.oralgpt.service.DbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class DbServiceTest {

    @Mock
    private ChatMapper chatMapper;

    @InjectMocks
    private DbService dbService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetChatById() {
        int id = 1;
        when(chatMapper.getChatById(id)).thenReturn(new Chat());
        // 调用DbService中的getChatById方法，预期不会抛出异常
        dbService.getChatById(id);
    }

    @Test
    public void testAddChat() {
        Chat chat = new Chat();
        // 调用DbService中的addChat方法，预期不会抛出异常
        dbService.addChat(chat);
        // 如果方法抛出了异常，那么测试会失败
        // 确保insertChat被调用了一次
        verify(chatMapper, times(1)).insertChat(any(Chat.class));
    }
}
