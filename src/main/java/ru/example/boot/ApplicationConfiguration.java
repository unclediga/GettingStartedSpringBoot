package ru.example.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Profile("ProfileA")
    MyMessage myMessageA(@Value("${my.messageA}") String mValue){
        MyMessage myMessage = new MyMessage();
        myMessage.setMessage(mValue);
        return myMessage;
    }

    @Bean
    @Profile("ProfileB")
    MyMessage myMessageB(@Value("${my.messageB}") String mValue){
        MyMessage myMessage = new MyMessage();
        myMessage.setMessage(mValue);
        return myMessage;
    }
}
