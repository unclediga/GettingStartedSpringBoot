package ru.example.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @SpringBootApplication consist of:
//      @EnableAutoConfiguration
//      @ComponentScan
//      @Configuration
@SpringBootApplication
public class Application {
    @Value("${name}")
    String name;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello from " + name + "!";
    }

    @Autowired
    String message;

    @RequestMapping("/message")
    public String helloBean() {
        return message;
    }

    @Autowired
    MyRandomNumber randomNumber;

    @RequestMapping("/rnd")
    public String randNum() {
        return "Random number is " + randomNumber.getNumber();
    }
// if there are no one profiles provided, then need qualifiers
//    @Qualifier("myMessageA")
//    @Qualifier("myMessageB")
    @Autowired
    MyMessage myMessage;

    @RequestMapping("/profile")
    public String profileMessage() {
        return myMessage.getMessage();
    }
}
