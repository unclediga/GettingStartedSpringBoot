package ru.example.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "my")
@Component
public class MyAutoConfigMessage {
    private String messageValue1;
    private String messageValue2;
    private String messageValue3;

    public String getMessageValue1() {
        return messageValue1;
    }

    public void setMessageValue1(String messageValue1) {
        this.messageValue1 = messageValue1;
    }

    public String getMessageValue2() {
        return messageValue2;
    }

    public void setMessageValue2(String messageValue2) {
        this.messageValue2 = messageValue2;
    }

    public String getMessageValue3() {
        return messageValue3;
    }

    public void setMessageValue3(String messageValue3) {
        this.messageValue3 = messageValue3;
    }
}
