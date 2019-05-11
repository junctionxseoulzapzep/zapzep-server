package com.example.zepzep.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendLocationMessage {
    private String content;

    public SendLocationMessage(String content) {
        this.content = content;
    }

}
