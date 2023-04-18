package com.gpt;

import com.config.ProxyConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.OpenAiApi;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.util.List;

import static com.theokanning.openai.service.OpenAiService.*;

@Service
public class GPTService {


    @Value("${gpt.privateKey}")
    private String privateKey;

    @Resource
    private ProxyConfig proxyConfig;


    public void chat(){

    }
}

