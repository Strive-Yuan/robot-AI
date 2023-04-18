package com.gpt.chat;

import com.config.ProxyConfig;
import com.gpt.model.Model;
import com.util.HttpsUtils;
import com.util.Jackson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private static final String CREATE_CHAT_URL = "https://api.openai.com/v1/chat/completions";

    @Value("${gpt.privateKey}")
    private String privateKey;

    @Resource(name = "ChatProxy")
    private Proxy proxy;


    public ChatResponse createChat() {
        System.out.println("proxy:"+proxy);
        var query = new ChatQuery();
        query.model = Model.GPT_THREE_POINT_FIVE_TURBO.description();
        List<Message> list = new ArrayList<>();
        list.add(new Message("user", "继续"));
        query.messages = list;
        String result;
        ChatResponse chatResponse = null;
        try {
            result = HttpsUtils.doPost(CREATE_CHAT_URL, proxy, Jackson.toJson(query));
            chatResponse = Jackson.fromJson(result, ChatResponse.class);
            System.out.println(Jackson.toJson(chatResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chatResponse;
    }
}
