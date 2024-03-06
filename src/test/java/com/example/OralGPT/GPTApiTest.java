import com.example.OralGPT.service.GptService;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = com.example.OralGPT.OralGptApplication.class)
@ExtendWith(SpringExtension.class)
public class GPTApiTest {
    private List<ChatMessage> messages = new ArrayList<>();

    @Autowired
    private GptService gptService;

    @Test
    public void createChatCompletion2() {

    }

}
