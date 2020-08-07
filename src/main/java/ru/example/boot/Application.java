package ru.example.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Import(MyConfiguration.class)
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
}
