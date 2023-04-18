package com.gpt.chat;

import java.io.Serializable;
import java.util.List;

public class ChatQuery implements Serializable {
    public String model;
    public List<Message> messages;
}
