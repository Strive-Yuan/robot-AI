package com.gpt.chat;

import java.io.Serializable;

public class Message implements Serializable {
        public String role;
        public String content;

        public Message() {
        }

        public Message(String role, String content) {
                this.role = role;
                this.content = content;
        }
}
