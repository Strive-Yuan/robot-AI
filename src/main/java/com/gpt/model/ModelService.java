package com.gpt.model;

import com.util.HttpsUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.Proxy;

@Service
public class ModelService {
    private static final String MODEL_LIST_URL = "https://api.openai.com/v1/models";

    @Resource(name = "ChatProxy")
    private Proxy proxy;

    public void modelList() {

//        try {
//            System.out.println("model list....");
//            String s = HttpsUtils.doGet(MODEL_LIST_URL, proxy, null);
//            System.out.println("s:" + s);
//        } catch (Exception e) {
//
//        }

    }
}
