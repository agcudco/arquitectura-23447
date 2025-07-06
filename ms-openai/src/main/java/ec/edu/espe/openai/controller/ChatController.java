package ec.edu.espe.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {


    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/consulta/")
    public String chat(@RequestParam String texto) {
        return this.chatClient.prompt()
                .user(texto)
                .call()
                .content();
    }

    @GetMapping("/historia/")
    @ResponseBody
    public Map<String, String> stories(@RequestParam String texto) {
        String response = this.chatClient.prompt()
                .user(texto)
                .call()
                .content();

        Map<String, String> map = new HashMap<>();
        map.put("texto", response);
        map.put("estado", "OK");
        return map;
    }


}
